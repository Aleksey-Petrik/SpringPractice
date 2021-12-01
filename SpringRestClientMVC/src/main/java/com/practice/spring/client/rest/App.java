package com.practice.spring.client.rest;

import com.practice.spring.client.rest.configuration.Config;
import com.practice.spring.client.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * REST API Client
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Communication communication = context.getBean("communication", Communication.class);

        communication.getEmployees().forEach(System.out::println);

        System.out.println("\n" + communication.getEmployee(1));

        communication.saveEmployee(new Employee(0, "Ivan", "Petrov", "HR", 5000));

        communication.saveEmployee(new Employee(1, "Masha", "Petrova", "HR", 1700));

        communication.deleteEmployee(11);

        context.close();
    }
}
