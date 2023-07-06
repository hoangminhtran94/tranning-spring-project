package com.minhhoangtran.firstspringproject;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GradeController {

    List<Grade> studentGrades = new ArrayList<>();

    @GetMapping("/grades")
    public String sayHello(Model model) {
        studentGrades.add(new Grade("Harry", "Potion", "C-"));
        studentGrades.add(new Grade("Harry", "Potion", "C-"));
        studentGrades.add(new Grade("Harry", "Potion", "C-"));
        model.addAttribute("grade", studentGrades);
        return "grades";
    }
    
}
