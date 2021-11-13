package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAround {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        String name = uniLibrary.returnBookName("Война и Мир");
        System.out.println("Вернули книгу - " + name);
        context.close();
    }

}
