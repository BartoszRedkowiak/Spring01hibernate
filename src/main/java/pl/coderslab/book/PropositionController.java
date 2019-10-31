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
import pl.coderslab.validate.ValidationProposition;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/propositions")
public class PropositionController implements ControllerInterface<Book> {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @Autowired
    public PropositionController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Book> props = bookService.findAll(true);
        model.addAttribute("props", props);
        return "propList";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("book", new Book());
        return "book";
    }

    @PostMapping("/add")
    public String add(@Validated({ValidationProposition.class})
                      @ModelAttribute Book proposition,
                      BindingResult result){
        if (result.hasErrors()){
            return "book";
        }
        proposition.setProposition(true);
        bookService.save(proposition);
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
        Book proposition = bookService.findBookWithAuthors(id);
        model.addAttribute("book", proposition);
        return "book";
    }

    @PostMapping("/update/{id}")
    public String update(@Validated({ValidationProposition.class})
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