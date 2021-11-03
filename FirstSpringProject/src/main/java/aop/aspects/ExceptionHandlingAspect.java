package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3) // аннотация, которая управляет очередностью классов аспектов
public class ExceptionHandlingAspect {

    @Before("aop.aspects.MyPointcuts.allGetMethods()")
    public void beforeGetExceptionHandlingAdvice() {
        System.out.println("3 - beforeGetExceptionHandlingAdvice: ловим/обрабатываем исключения при попытки получить книгу/журнал.");
    }

    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddExceptionHandlingAdvice() {
        System.out.println("3 - beforeAddExceptionHandlingAdvice: ловим/обрабатываем исключения при попытки получить книгу/журнал.");
    }

}
