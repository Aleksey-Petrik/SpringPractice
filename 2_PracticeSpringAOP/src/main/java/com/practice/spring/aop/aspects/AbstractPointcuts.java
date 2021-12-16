package com.practice.spring.aop.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Pointcut;

/*
 * Общие классы Аспектов помечать аннотациями @Component и @Aspect не нужно
 *
 * */
public abstract class AbstractPointcuts {
    protected final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    /*
     * Написание общих Pointcut-ов для нескольких методов
     * к примеру один логгирует,
     * */
    @Pointcut("execution(* return*())")
    public void allReturnMethods() {
    }

    @Pointcut("execution(* com.practice.spring.aop.UniLibrary.get*())")
    public void allGetMethodsFromUniLibrary() {
    }

    @Pointcut("execution(* com.practice.spring.aop.UniLibrary.return*())")
    public void allReturnMethodsFromUniLibrary() {
    }

    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
    public void allGetAndReturnMethodsFromUniLibrary() {
    }
}
