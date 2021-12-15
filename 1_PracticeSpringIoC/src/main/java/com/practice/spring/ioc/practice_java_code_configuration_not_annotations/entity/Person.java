package com.practice.spring.ioc.practice_java_code_configuration_not_annotations.entity;

import org.springframework.beans.factory.annotation.Value;

public class Person {
    private Pet pet;
    private Pet secondPet;
    @Value("${person.name}")//значение берется из myApp.properties
    private String name;
    @Value("${person.age}")//значение берется из myApp.properties
    private int age;

    public Person(Pet pet) {
        this.pet = pet;
        System.out.println("Person is created");
    }

    public void setSecondPet(Pet secondPet) {
        this.secondPet = secondPet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void callYouPet() {
        System.out.println("Hello, my's lovelies pets!");
        if (pet != null) {
            pet.say();
        }
        if (secondPet != null) {
            secondPet.say();
        }
    }

}
