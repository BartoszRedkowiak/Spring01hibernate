package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.ControllerInterface;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

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
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "bookList";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("book", new Book());
        return "book";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Book book){
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
    public String update(@ModelAttribute Book book){
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
