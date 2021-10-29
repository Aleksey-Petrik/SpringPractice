package spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        test();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();//annotations
        test8();//annotations
        test9();//annotations
        test10();//annotations
        test11();//annotations
    }

    public static void test() {
        System.out.println("Test - 1");
        //Создание бинов с помощью xml
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Pet pet = context.getBean("myPet", Pet.class);
        pet.say();
        //Обязательно закрыть
        context.close();
    }

    public static void test2() {
        System.out.println("Test - 2");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Pet pet = context.getBean("myPet", Pet.class);
        Person person = new Person(pet);
        person.callMyPet();
        context.close();
    }

    public static void test3() {
        System.out.println("Test - 3");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("myPerson", Person.class);
        person.callMyPet();
        context.close();
    }

    public static void test4() {
        System.out.println("Test - 4");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("myPersonSet", Person.class);
        person.callMyPet();
        System.out.println("Name owner - " + person.getSurname());
        System.out.println("Age owner - " + person.getAge());
        context.close();
    }

    public static void test5() {
        System.out.println("Test(singleton) - 5");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextTestScopeSingleton.xml");
        Pet dog = context.getBean("myPet", Dog.class);
        Pet dogSecond = context.getBean("myPet", Dog.class);
        //Возвращает один и тот же объект
        System.out.println(dog);
        System.out.println(dogSecond);
        context.close();
    }

    public static void test6() {
        System.out.println("Test(prototype) - 6");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextTestScopePrototype.xml");
        Pet dog = context.getBean("myPet", Dog.class);
        Pet dogSecond = context.getBean("myPet", Dog.class);
        //Возвращаются разные объекты
        System.out.println(dog);
        System.out.println(dogSecond);
        context.close();
    }

    public static void test7() {
        System.out.println("Test(annotations) - 7");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");
        Cat cat = context.getBean("catBean", Cat.class);
        //Dog dog = context.getBean("dog", Dog.class);
        cat.say();
        //dog.say();
        context.close();
    }

    public static void test8() {
        System.out.println("Test(annotations) - 8");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");
        //Cat cat = context.getBean("catBean", Cat.class);
        //Dog dog = context.getBean("dog", Dog.class);
        Person person = context.getBean("personBean", Person.class);
        person.callMyPet();
        System.out.println(person.getSurname());
        System.out.println(person.getAge());
        context.close();
    }

    public static void test9() {
        System.out.println("Test(annotations Scope) - 9");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAnnotationsScope.xml");
        Cow cow = context.getBean("cow", Cow.class);
        Cow cowSecond = context.getBean("cow", Cow.class);
        cow.say();
        System.out.println(cow);
        System.out.println(cowSecond);
        context.close();
    }

    public static void test10() {
        System.out.println("Test(annotations Scope) - 10");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Person person = context.getBean("personBean", Person.class);
        person.callMyPet();
        System.out.println(person.getSurname());
        System.out.println(person.getAge());
        context.close();
    }

    public static void test11() {
        System.out.println("Test(annotations Scope) - 11");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class);
        Pet bear = context.getBean("bearBean", Bear.class);
        bear.say();

        PersonHunter personHunter = context.getBean("personHunterBean", PersonHunter.class);
        personHunter.callMyPet();

        System.out.println(personHunter.getName() + " " + personHunter.getAge());
        context.close();
    }

}
