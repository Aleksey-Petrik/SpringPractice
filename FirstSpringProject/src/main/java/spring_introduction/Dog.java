package spring_introduction;

import org.springframework.stereotype.Component;

@Component//id = Dog->dog
public class Dog implements Pet {

    @Override
    public void say() {
        System.out.println("Bow-wow");
    }

    /*
        прописывается в XML
        init-method="init" метод инициализации при создании бина
        destroy-method="destroy" метод который будет вызван перед уничтожением бина
        модификатор доступа может быть любым
        должны быть без параметров
        возвращаемое значение использовать мы не можем
        для scope="prototype" метод destroy-method вызываться не будет
    */

    private void init() {
        System.out.println("Init beam dog");
    }

    private void destroy() {
        System.out.println("destroy beam dog");
    }

}
