package com.minhhoangtran.firstspringproject.service;

import java.util.List;

import com.minhhoangtran.firstspringproject.Grade;
import com.minhhoangtran.firstspringproject.repository.GradeRepository;

public class GradeService {
    GradeRepository gradeRepository = new GradeRepository();

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
