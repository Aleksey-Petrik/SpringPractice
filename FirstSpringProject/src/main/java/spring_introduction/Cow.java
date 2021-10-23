package spring_introduction;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")//singleton - один экземпляр класса и prototype - при каждом обращении новый
public class Cow implements Pet {

    @Override
    public void say() {
        System.out.println("My-my");
    }

    @PostConstruct//аннотация выполняется после создания бина
    private void init(){
        System.out.println("Создали cow");
    }

    @PreDestroy//аннотация выполняется после уничтожения бина
    private void destroy(){
        System.out.println("Убили cow");
    }

}
