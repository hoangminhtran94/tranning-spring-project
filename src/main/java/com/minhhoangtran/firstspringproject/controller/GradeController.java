package com.minhhoangtran.firstspringproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.minhhoangtran.firstspringproject.Grade;
import com.minhhoangtran.firstspringproject.service.GradeService;

import jakarta.validation.Valid;

@Controller
public class GradeController {

    @Autowired
    GradeService gradeService;

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", gradeService.getGrades());
        return "grades";
    }

    @GetMapping(value = "/")
    public String gradeForm(Model model, @RequestParam(required = false) String id) {
        Grade grade = gradeService.getGradeForm((id));
        model.addAttribute("grade", grade);
        return "form";
    }

    @PostMapping("/")
    public String submitGrade(@Valid Grade grade, BindingResult result) {
        if (result.hasErrors())
            return "form";

        gradeService.submitGrade(grade);
        return "redirect:/grades";

    }

}
