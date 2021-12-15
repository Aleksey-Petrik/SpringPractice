package com.practice.spring.ioc.practice_java_code_configuration_not_annotations.entity;

public class Cow implements Pet {

    public Cow() {
        System.out.println("Cow is created");
    }

    @Override
    public void say() {
        System.out.println("Myyy-myyy");
    }
}
