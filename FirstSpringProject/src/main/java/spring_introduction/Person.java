package spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {
    private Pet pet;
    private String surname;
    private int age;

    @Autowired//автоматическое внедрение зависимостей, если есть входные параметры для бинов, применять можно и для сеттеров
    public Person(Pet pet) {
        this.pet = pet;
    }

    public Person() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void callMyPet() {
        System.out.println("Hello my pet");
        pet.say();
    }
}
