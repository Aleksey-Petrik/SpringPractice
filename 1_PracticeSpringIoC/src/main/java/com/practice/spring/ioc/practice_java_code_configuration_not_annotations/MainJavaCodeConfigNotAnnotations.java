package com.practice.spring.ioc.practice_java_code_configuration_not_annotations;

import com.practice.spring.ioc.practice_java_code_configuration_not_annotations.configuration.Config;
import com.practice.spring.ioc.practice_java_code_configuration_not_annotations.entity.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaCodeConfigNotAnnotations {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Person person = context.getBean("personBean", Person.class);
        person.callYouPet();
        System.out.println(person.getName() + "/" + person.getAge());

        context.close();
    }
}
