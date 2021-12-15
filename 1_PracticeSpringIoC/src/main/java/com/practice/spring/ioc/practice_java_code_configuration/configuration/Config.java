package com.practice.spring.ioc.practice_java_code_configuration.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.practice.spring.ioc.practice_java_code_configuration")
@PropertySource("classpath:myApp.properties")//подгружаем файл ресурсов
public class Config {

}
