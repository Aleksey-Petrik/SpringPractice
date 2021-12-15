package com.practice.spring.ioc.practice_xml_annotations;

import com.practice.spring.ioc.practice_xml_annotations.entity.Cat;
import com.practice.spring.ioc.practice_xml_annotations.entity.Cow;
import com.practice.spring.ioc.practice_xml_annotations.entity.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXMLAnnotations {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContextXMLandAnnotations.xml");

        Cat cat = context.getBean("beanCat", Cat.class);
        cat.say();

        Person person = context.getBean("beanPerson", Person.class);
        person.callYouPet();

        System.out.println(person.getName() + "/" + person.getAge());

        Cow cow = context.getBean("beanCow", Cow.class);
        Cow cowSecond = context.getBean("beanCow", Cow.class);
        System.out.println(cow);
        System.out.println(cowSecond);

        context.close();
    }

}
