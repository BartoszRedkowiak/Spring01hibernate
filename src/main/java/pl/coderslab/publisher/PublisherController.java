package pl.coderslab.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.ControllerInterface;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/publishers")
public class PublisherController implements ControllerInterface<Publisher> {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @Override
    @GetMapping("/list")
    public String list(Model model) {
        List<Publisher> publishers = publisherService.findAllWithBooks();
        model.addAttribute("publishers", publishers);
        return "publisherList";
    }

    @Override
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisher";
    }

    @Override
    @PostMapping("/add")
    public String add(@Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors()){
            return "publisher";
        }
        publisherService.save(publisher);
        return "redirect:list";
    }

    @Override
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        publisherService.delete(id);
        return "redirect:../list";
    }

    @Override
    @GetMapping("/update/{id}")
    public String update(@PathVariable long id,
                         Model model) {
        Publisher publisher = publisherService.findOne(id);
        model.addAttribute("publisher", publisher);
        return "publisher";
    }

    @Override
    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute Publisher publisher, BindingResult result) {
        if (result.hasErrors()){
            return "publisher";
        }
        publisherService.update(publisher);
        return "redirect:../list";
    }
}
