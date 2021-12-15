package com.practice.spring.ioc.practice_xml_config.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cat implements Pet, InitializingBean, DisposableBean {

    /*
     * InitializingBean - имплемент метод инициализирует бин
     * DisposableBean - имплемент метод уничтожает бин
     * */

    public Cat() {
        System.out.println("Cat is created");
    }

    @Override
    public void say() {
        System.out.println("Meow-meow");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Init CAT");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy CAT");
    }
}
