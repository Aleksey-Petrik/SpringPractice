package com.practice.spring.ioc.practice_xml_config;

import com.practice.spring.ioc.practice_xml_config.entity.Dog;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainPracticeBeanScopeSingleton {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextBeanScopeSingleton.xml");

        Dog dog = context.getBean("myDog", Dog.class);
        Dog dogSecond = context.getBean("myDog", Dog.class);
        System.out.println(dog);
        System.out.println(dogSecond);
        System.out.println("Бины ссылаются на один и тот же объект? - " + (dog == dogSecond ? "YES" : "NO"));
        context.close();
    }
}
