package com.practice.spring.ioc;

import com.practice.spring.ioc.entity.Pet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Practice Inversion of Control
 */
public class MainPracticeIoC {
    public static void main(String[] args) {
        //Создание spring контейнера, контейнер бинов
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Получение объекта из контейнера
        Pet cat = context.getBean("myCat", Pet.class);
        cat.say();

        Pet dog = context.getBean("myDog", Pet.class);
        dog.say();

        context.close();
    }
}
