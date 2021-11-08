package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private final List<Student> students = new ArrayList<>();

    public void addStudents() {
        Student st1 = new Student("Alex", 4, 7.7);
        Student st2 = new Student("Vlad", 2, 6.9);
        Student st3 = new Student("Petr", 1, 9.0);

        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents() {
        System.out.println("Information from method getStudents:");
        System.out.println("Student 4 - " + students.get(3));
        System.out.println(students);
        return students;
    }

}
