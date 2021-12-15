package com.practice.spring.ioc.practice_xml_annotations.entity;

import org.springframework.stereotype.Component;

@Component("beanCat")//в скобочках можно указать ID бина
public class Cat implements Pet {

    public Cat() {
        System.out.println("Cat is created");
    }

    @Override
    public void say() {
        System.out.println("Meow-meow");
    }
}
