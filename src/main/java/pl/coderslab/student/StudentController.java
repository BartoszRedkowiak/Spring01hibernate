package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.person.Person;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("student", new Student());
        return "student";
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(@ModelAttribute Student student){
        return student.toString();
    }


    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("skills")
    public List<String> skills(){
        return Arrays.asList("Java", "PHP", "Python", "Ruby", "Javascript");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies(){
        return Arrays.asList("longboarding", "football", "cycling", "basketball", "frisbee");
    }






}
