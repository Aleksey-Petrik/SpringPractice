package com.practice.spring.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)//приоритет загрузки, чем ниже цифра тем выше приоритет
public class LoggingAspect extends AbstractPointcuts {

    //@Before("execution(public void com.practice.spring.aop.SchoolLibrary.getBook())")//"execution(public void getBook())" - pointcut
    @Before("execution(public void get*(..))")//"execution(public void getBook())" - pointcut
    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }

    /*
     * Для логгирования
     * */
    @Before("allReturnMethods()")
    public void beforeReturnBookLoggingAdvice() {
        System.out.println("beforeReturnBookLoggingAdvice: попытка вернуть книгу, логгирование");
    }

    @Before("com.practice.spring.aop.aspects.AbstractPointcuts.allGetAndReturnMethodsFromUniLibrary()")
    public void beforeGetLoggingAdvice() {
        logger.info("beforeGetLoggingAdvice: writing Log #1");
    }

    @Before("com.practice.spring.aop.aspects.AbstractPointcuts.allReturnMethodsFromUniLibrary()")
    public void beforeReturnLoggingAdvice() {
        logger.info("beforeGetLoggingAdvice: writing Log #2");
    }

    @Before("com.practice.spring.aop.aspects.AbstractPointcuts.allGetAndReturnMethodsFromUniLibrary()")
    public void beforeGetAndReturnLoggingAdvice() {
        logger.info("beforeGetLoggingAdvice: writing Log #3");
    }

    /*
    * С помощью аргумента JoinPoint можем получить информацию по отслеживаемому методу и его параметрам
    * */
    @Before("allAddMethodsFromUniLibrary()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint){
        Object[] objects = joinPoint.getArgs();
        logger.info("beforeAddLoggingAdvice: попытка добавить книгу {} {}", objects, joinPoint.getSignature().getName());
    }
}
