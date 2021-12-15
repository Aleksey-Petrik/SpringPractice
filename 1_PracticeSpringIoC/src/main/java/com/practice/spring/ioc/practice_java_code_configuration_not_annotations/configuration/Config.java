package com.practice.spring.ioc.practice_java_code_configuration_not_annotations.configuration;

import com.practice.spring.ioc.practice_java_code_configuration_not_annotations.entity.Cat;
import com.practice.spring.ioc.practice_java_code_configuration_not_annotations.entity.Dog;
import com.practice.spring.ioc.practice_java_code_configuration_not_annotations.entity.Person;
import com.practice.spring.ioc.practice_java_code_configuration_not_annotations.entity.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:myApp.properties")//подгружаем файл ресурсов
public class Config {

    @Bean//создается бин и помещаем его в контейнер
    @Scope("singleton")
    public Pet catBean() {
        return new Cat();
    }

    @Bean
    @Scope("singleton")
    public Pet dogBean() {
        return new Dog();
    }

    @Bean
    @Scope("singleton")
    public Person personBean() {
        return new Person(catBean());
    }
}
