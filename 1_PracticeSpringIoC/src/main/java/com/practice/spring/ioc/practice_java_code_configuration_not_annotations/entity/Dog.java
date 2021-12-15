package com.practice.spring.ioc.practice_java_code_configuration_not_annotations.entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog implements Pet {

    public Dog() {
        System.out.println("Dog is created");
    }

    @Override
    public void say() {
        System.out.println("Bow-wow");
    }

    @PostConstruct
    private void init() {
        System.out.println("Dog init");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Dog destroy");
    }
}
