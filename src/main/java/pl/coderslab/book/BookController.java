package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.ControllerInterface;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;
import pl.coderslab.validate.ValidationBook;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController implements ControllerInterface<Book> {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Book> books = bookService.findAll(false);
        model.addAttribute("books", books);
        return "bookList";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("book", new Book());
        return "book";
    }

    @PostMapping("/add")
    public String add(@Validated({ValidationBook.class})
                      @ModelAttribute Book book,
                      BindingResult result){
        if (result.hasErrors()){
            return "book";
        }
        book.setProposition(false);
        bookService.save(book);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        bookService.delete(id);
        return "redirect:../list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable long id,
                         Model model){
        Book book = bookService.findBookWithAuthors(id);
        model.addAttribute("book", book);
        return "book";
    }

    @PostMapping("/update/{id}")
    public String update(@Validated({ValidationBook.class})
                         @ModelAttribute Book book,
                         BindingResult result){
        if (result.hasErrors()){
            return "book";
        }
        bookService.update(book);
        return "redirect:../list";
    }

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers(){
        return publisherService.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors() {
        return authorService.findAll();
    }

}
