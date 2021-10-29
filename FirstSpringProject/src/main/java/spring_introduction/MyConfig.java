package spring_introduction;

import org.springframework.context.annotation.*;
/*
Первый способ описания конфигурации с помощью сканирования пакета
 */
@Configuration//говорит о том что данный файл является конфигурацией
@ComponentScan("spring_introduction")//указывается пакет, который будет просканирован на наличие бинов и аннотаций
@PropertySource("classpath:myApp.properties")//указываем из какого файла брать значения для полей
public class MyConfig {

    @Bean
    @Scope("singleton")
    public Dog dog() {
        return new Dog();
    }

    @Bean
    public Person personBean() {
        return new Person(dog());
    }
}
