package com.minhhoangtran.firstspringproject.repository;

import java.util.ArrayList;
import java.util.List;

import com.minhhoangtran.firstspringproject.Constants;
import com.minhhoangtran.firstspringproject.Grade;

public class GradeRepository {
    private List<Grade> studentGrades = new ArrayList<>();

    public List<Grade> getGrades() {
        return studentGrades;
    }

    public int getGradeIndex(String id) {
        for (int i = 0; i < studentGrades.size(); i++) {
            if (studentGrades.get(i).getId().equals(id))
                return i;
        }
        return Constants.NOT_FOUND;
    }

    public Grade getGrade(int index) {
        return studentGrades.get(index);
    }

    public void addGrade(Grade grade) {
        studentGrades.add(grade);
    }

    public void updateGrade(int index, Grade grade) {
        studentGrades.set(index, grade);
    }

}
