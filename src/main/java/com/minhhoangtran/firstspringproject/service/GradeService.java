package com.minhhoangtran.firstspringproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minhhoangtran.firstspringproject.Grade;
import com.minhhoangtran.firstspringproject.repository.GradeRepository;

@Service
public class GradeService {
    @Autowired
    GradeRepository gradeRepository;

    public List<Grade> getGrades() {
        return gradeRepository.getGrades();
    }

    public Grade getGradeForm(String id) {
        int index = gradeRepository.getGradeIndex(id);
        Grade grade = index < 0 ? new Grade() : gradeRepository.getGrade(index);
        return grade;
    }

    public void submitGrade(Grade grade) {
        int index = gradeRepository.getGradeIndex(grade.getId());
        if (index < 0) {
            gradeRepository.addGrade(grade);
        } else {
            gradeRepository.updateGrade(index, grade);
        }
    }

}
