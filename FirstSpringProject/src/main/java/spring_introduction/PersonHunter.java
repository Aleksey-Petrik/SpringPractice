package spring_introduction;

import org.springframework.beans.factory.annotation.Value;

public class PersonHunter {
    private final Pet pet;
    @Value("${person.surname}")//значения для полей будут взяты из файла properties
    private String name;
    @Value("${person.age}")//значения для полей будут взяты из файла properties
    private int age;

    public PersonHunter(Pet pet) {
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void callMyPet() {
        System.out.println("Hello my pet");
        pet.say();
    }

}
