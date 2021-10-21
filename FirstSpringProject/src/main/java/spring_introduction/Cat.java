package spring_introduction;

import org.springframework.stereotype.Component;

@Component("catBean")//Если id не указывать, то по умолчанию id будет равен имени класса первая буква будет строчной Cat->cat
public class Cat implements Pet {

    @Override
    public void say() {
        System.out.println("Meow-meow");
    }

}
