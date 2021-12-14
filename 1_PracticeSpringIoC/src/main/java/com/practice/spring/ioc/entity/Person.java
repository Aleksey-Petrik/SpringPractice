package com.practice.spring.ioc.entity;

public class Person {
    private final Pet pet;
    private Pet secondPet;
    private String name;
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
        pet.say();
        secondPet.say();
    }

}
