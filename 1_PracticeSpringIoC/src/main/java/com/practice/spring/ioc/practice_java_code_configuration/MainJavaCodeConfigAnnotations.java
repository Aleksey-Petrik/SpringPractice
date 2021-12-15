package com.practice.spring.ioc.practice_java_code_configuration;

import com.practice.spring.ioc.practice_java_code_configuration.configuration.Config;
import com.practice.spring.ioc.practice_java_code_configuration.entity.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaCodeConfigAnnotations {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Person person = context.getBean("beanPerson", Person.class);
        person.callYouPet();
        System.out.println(person.getName() + "/" + person.getAge());

        context.close();
    }
}
