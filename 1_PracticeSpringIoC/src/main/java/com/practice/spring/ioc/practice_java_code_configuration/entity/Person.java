package com.practice.spring.ioc.practice_java_code_configuration.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("beanPerson")
public class Person {
    private Pet pet;
    @Autowired//спринг автоматически подставит бин из контейнера в конструктор
    @Qualifier("dog")
    private Pet secondPet;

    @Value("${person.name}")//значение берется из myApp.properties
    private String name;
    @Value("${person.age}")//значение берется из myApp.properties
    private int age;

    @Autowired//спринг автоматически подставит бин из контейнера в конструктор
    public Person(@Qualifier("beanCat") Pet pet) {
        this.pet = pet;
        System.out.println("Person is created");
    }

    @Autowired//спринг автоматически подставит бин из контейнера в конструктор
    @Qualifier("dog")
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
