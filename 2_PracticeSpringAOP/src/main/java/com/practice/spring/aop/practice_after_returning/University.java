package com.practice.spring.aop.practice_after_returning;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private final List<Student> students = new ArrayList<>();

    public Student addStudents(Student student) {
        students.add(student);
        return student;
    }

    public List<Student> getStudents() {
        System.out.println("Information from method getStudents: ");
        System.out.println(students);
        System.out.println(students.get(5));
        return students;
    }
}
