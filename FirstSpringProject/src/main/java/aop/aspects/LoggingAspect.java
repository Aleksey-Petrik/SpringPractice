package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect//аннотация которая говорит о том что данный класс является аспектом
public class LoggingAspect {

    //Pointcut - выражения, описывающее где должен применен Advice
    //execution - писываем шаблон метода
    //модификатор доступа?, возвращаемый тип или void!, класс?, имя метода(параметры)!, исключения которые выбрасывает метод exceptions?
    //если не указывать класс в котором метод, то программа будет брать все методы подходящие по шаблону
    //@Before("execution(public void aop.UniLibrary.getBook())")//данная аннотация задает возможность запуска метода перед ключевым, к примеру для логгирования
    @Before("execution(public void get*())")//возьмутся все методы у которых имя начинается на get
    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvance : Попытка получить книгу");
    }

    //модификатор доступа не является обязательным, а звездочка в параметре возвращаемого типа говорит о том что тип может быть любой
    //execution(* *()) любой модификатор доступа, любой возвращаемый тип, любое имя метода, в любом классе может находится
    @Before("execution(* returnBook())")
    public void beforeReturnBookAdvice() {
        System.out.println("beforeGetBookAdvance : Попытка вернуть книгу");
    }

}
