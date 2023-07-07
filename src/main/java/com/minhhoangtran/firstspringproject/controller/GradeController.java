package com.minhhoangtran.firstspringproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.minhhoangtran.firstspringproject.Grade;
import com.minhhoangtran.firstspringproject.repository.GradeRepository;

import jakarta.validation.Valid;

@Controller
public class GradeController {
    GradeRepository gradeRepository = new GradeRepository();

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", gradeRepository.getGrades());
        return "grades";
    }

    @GetMapping(value = "/")
    public String gradeForm(Model model, @RequestParam(required = false) String id) {
        int index = gradeRepository.getGradeIndex(id);
        Grade grade = index < 0 ? new Grade() : gradeRepository.getGrade(index);
        model.addAttribute("grade", grade);
        return "form";
    }

    @PostMapping("/")
    public String submitGrade(@Valid Grade grade, BindingResult result) {
        if (result.hasErrors())
            return "form";

        int index = gradeRepository.getGradeIndex(grade.getId());
        if (index < 0) {
            gradeRepository.addGrade(grade);
        } else {
            gradeRepository.updateGrade(index, grade);
        }
        return "redirect:/grades";

    }

}
