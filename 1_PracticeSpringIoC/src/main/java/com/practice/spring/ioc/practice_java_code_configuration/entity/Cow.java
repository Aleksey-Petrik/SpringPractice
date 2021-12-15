package com.practice.spring.ioc.practice_java_code_configuration.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("beanCow")//в скобочках можно указать ID бина
@Scope("prototype")//default @Scope("singleton") указываем каким способом будут возвращаться бины
public class Cow implements Pet {

    public Cow() {
        System.out.println("Cow is created");
    }

    @Override
    public void say() {
        System.out.println("Myyy-myyy");
    }
}
