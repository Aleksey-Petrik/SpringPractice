package com.practice.spring.ioc.practice_xml_config.entity;

public class Dog implements Pet {

    public Dog() {
        System.out.println("Dog is created");
    }

    @Override
    public void say() {
        System.out.println("Bow-wow");
    }

    private void init() {
        System.out.println("Init DOG");
    }

    private void destroy() {
        System.out.println("Destroy DOG");
    }
}
