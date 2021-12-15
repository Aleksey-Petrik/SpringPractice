package com.practice.spring.ioc.practice_java_code_configuration_not_annotations.entity;

public class Cat implements Pet {

    public Cat() {
        System.out.println("Cat is created");
    }

    @Override
    public void say() {
        System.out.println("Meow-meow");
    }
}
