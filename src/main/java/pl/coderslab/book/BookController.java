package pl.coderslab.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @GetMapping("/add")
    @ResponseBody
    public String add(){

        Publisher publisher = new Publisher();
        publisher.setName("Publisher 1");

        publisherService.save(publisher);

        Author author = new Author();
        author.setFirstName("Bruce");
        author.setLastName("Eckel");

        List<Author> authors = new ArrayList<>();
        authors.add(author);
        authors.forEach(a->authorService.save(a));

        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setPublisher(publisher);
        book.setAuthors(authors);

        bookService.save(book);
        return "Book added, id = " + book.getId();
    }

    @GetMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable Long id){
        Book book = bookService.findOne(id);
        book.setTitle("Thinking not in Java");

        bookService.update(book);
        return "Updated book with id = " + book.getId() + ", new title = " + book.getTitle();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){
        bookService.delete(id);
        return "Deleted book with id = " + id;
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public String find(@PathVariable Long id){
        Book book = bookService.findOne(id);
        if (book != null){
            return book.toString();
        }
        return "Book not found";
    }



}
