package com.practice.spring.ioc.practice_java_code_configuration.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
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
