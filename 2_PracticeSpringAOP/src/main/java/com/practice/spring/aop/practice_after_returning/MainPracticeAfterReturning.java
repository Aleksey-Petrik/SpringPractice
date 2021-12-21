package com.practice.spring.aop.practice_after_returning;

import com.practice.spring.aop.configuration.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainPracticeAfterReturning {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        University university = context.getBean("university", University.class);
        university.addStudents(new Student("Alex", 3, 6.7));
        university.addStudents(new Student("Vlad", 1, 4.7));
        university.addStudents(new Student("Via", 2, 3.6));

        try {
            university.getStudents();
            university.getStudents();
        }catch (Exception e){
            System.out.println("Exception - " + e.getMessage());
        }
        context.close();
    }
}
