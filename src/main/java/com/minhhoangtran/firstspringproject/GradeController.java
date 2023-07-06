package com.minhhoangtran.firstspringproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeController {

    List<Grade> studentGrades = new ArrayList<>();

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", studentGrades);
        return "grades";
    }

    @GetMapping(value = "/")
    public String gradeForm(Model model, @RequestParam(required = false) String name) {
        int index = getGradeIndex(name);
        Grade grade = index < 0 ? new Grade() : studentGrades.get(index);
        model.addAttribute("grade", grade);
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitGrade(Grade grade) {
        int index = getGradeIndex(grade.getName());
        if (index < 0) {
            studentGrades.add(grade);
        } else {
            studentGrades.set(index, grade);
        }
        return "redirect:/grades";

    }

    public int getGradeIndex(String name) {
        for (int i = 0; i < studentGrades.size(); i++) {
            if (studentGrades.get(i).getName().equals(name))
                return i;
        }
        return -9999;
    }

}
