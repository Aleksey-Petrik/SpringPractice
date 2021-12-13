package com.practice.spring.ioc;

import com.practice.spring.ioc.entity.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Practice Inversion of Control
 */
public class MainPracticeDI {
    public static void main(String[] args) {
        //Создание spring контейнера, контейнер бинов
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Spring обращая внимание на конфиг файл, помещает объект Pet в объект Person
        Person person = context.getBean("myPerson", Person.class);
        person.callYouPet();
        context.close();
    }
}
