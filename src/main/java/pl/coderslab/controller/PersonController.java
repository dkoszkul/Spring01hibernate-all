package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Person;

import java.util.List;

@Controller
public class PersonController {

    @GetMapping("form1")
    public String form1(Model model) {
        model.addAttribute("person", new Person());
        return "form1";
    }

    @PostMapping("newPerson")
    @ResponseBody
    public String newPerson(@ModelAttribute("person")Person person) {

        return person.toString();
    }

    @ModelAttribute("exampleList")
    public List<String> someList() {
        return List.of("a", "b");
    }
}
