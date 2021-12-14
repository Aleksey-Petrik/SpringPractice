package com.practice.spring.ioc;

import com.practice.spring.ioc.entity.Cat;
import com.practice.spring.ioc.entity.Dog;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainPracticeBeanInitDestroy {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextBeanMethodsInitDestroy.xml");

        Dog dog = context.getBean("myDog", Dog.class);
        dog.say();

        Cat cat = context.getBean("myCat", Cat.class);
        cat.say();
        context.close();
    }
}
