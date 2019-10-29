package pl.coderslab.author;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.ControllerInterface;
import pl.coderslab.book.Book;
import pl.coderslab.book.BookService;

import java.util.List;


@Controller
@RequestMapping("/authors")
public class AuthorController implements ControllerInterface<Author> {

    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    @GetMapping("/list")
    public String list(Model model) {
        List<Author> authors = authorService.findAllWithBooks();
        model.addAttribute("authors", authors);
        return "authorList";
    }

    @Override
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("author", new Author());
        return "author";
    }

    @Override
    @PostMapping("/add")
    public String add(Author author) {
        authorService.save(author);
        return "redirect:list";
    }

    @Override
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        authorService.delete(id);
        return "redirect:../list";
    }

    @Override
    @GetMapping("/update/{id}")
    public String update(@PathVariable long id,
                         Model model) {
        Author author = authorService.findOne(id);
        model.addAttribute("author", author);
        return "author";
    }

    @Override
    @PostMapping("/update/{id}")
    public String update(@ModelAttribute Author author) {
        authorService.update(author);
        return "redirect:../list";
    }

    @ModelAttribute("books")
    public List<Book> getBooks(){
        return bookService.findAll();
    }


}
