package com.practice.spring.ioc.entity;

public class Cat implements Pet {

    public Cat() {
        System.out.println("Cat is created");
    }

    @Override
    public void say() {
        System.out.println("Meow-meow");
    }
}
