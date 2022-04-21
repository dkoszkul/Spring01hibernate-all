package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Student;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    @GetMapping("student")
    public String createNewStudentPage(Model model) {
        model.addAttribute("student", new Student());
        return "student";
    }

    @PostMapping("student")
    @ResponseBody
    public String createNewStudentPage(@ModelAttribute("student") Student student) {
        return student.toString();
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Java", "SQL", "Maven", "Git", "C++");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("Nothing", "TV", "PC", "Hiking", "Walking");
    }
}
