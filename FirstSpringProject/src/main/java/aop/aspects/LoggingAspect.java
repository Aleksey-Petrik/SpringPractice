package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect//аннотация которая говорит о том что данный класс является аспектом
public class LoggingAspect {

    @Before("execution(public void getBook())")//данная аннотация задает возможность запуска метода перед ключевым, к примеру для логгирования
    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvance : Попытка получить книгу");
    }
}
