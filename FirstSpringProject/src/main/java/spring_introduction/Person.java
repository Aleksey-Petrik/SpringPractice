package spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {

    @Autowired//автоматическое внедрение зависимостей, если есть входные параметры для бинов, применять можно и для сеттеров и полей класса
    @Qualifier("dog")//аннотация которая текущий бин использует для вставки зависимости если будут найдено несколько бинов одного типа
    private Pet pet;
    @Value("${person.surname}")//аннотация для инициализации поля, можно хардкодить, но не нужно
    private String surname;
    @Value("${person.age}")
    private int age;

    @Autowired//автоматическое внедрение зависимостей, если есть входные параметры для бинов, применять можно и для сеттеров
    public Person(@Qualifier("dog") Pet pet) {
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

    @Autowired//автоматическое внедрение зависимостей, если есть входные параметры для бинов, применять можно и для сеттеров
    @Qualifier("dog")//аннотация которая текущий бин использует для вставки зависимости если будут найдено несколько бинов одного типа
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void callMyPet() {
        System.out.println("Hello my pet");
        pet.say();
    }

}
