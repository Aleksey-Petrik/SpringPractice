package com.practice.spring.ioc.entity;

public class Person {
    private final Pet pet;
    private Pet secondPet;

    public Person(Pet pet) {
        this.pet = pet;
        System.out.println("Person is created");
    }

    public void setSecondPet(Pet secondPet) {
        this.secondPet = secondPet;
    }

    public void callYouPet() {
        System.out.println("Hello, my's lovelies pets!");
        pet.say();
        secondPet.say();
    }

}
