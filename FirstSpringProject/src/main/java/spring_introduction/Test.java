package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        test();
        test2();
        test3();
        test4();
        test5();
        test6();
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
}
