package com.practice.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)//приоритет загрузки, чем ниже цифра тем выше приоритет
public class SecurityAspect extends AbstractPointcuts {

    /*
     * Для проверки прав доступа
     * */
    @Before("allReturnMethods()")
    public void beforeReturnBookSecurityAdvice() {
        System.out.println("beforeReturnBookSecurityAdvice: попытка вернуть книгу, проверка прав доступа");
    }

    @Before("allGetAndReturnMethodsFromUniLibrary()")
    public void beforeGetSecurityAdvice() {
        logger.info("beforeGetSecurityAdvice: writing Log #1");
    }

    @Before("allReturnMethodsFromUniLibrary()")
    public void beforeReturnSecurityAdvice() {
        logger.info("beforeReturnSecurityAdvice: writing Log #2");
    }

    @Before("allGetAndReturnMethodsFromUniLibrary()")
    public void beforeGetAndReturnSecurityAdvice() {
        logger.info("beforeGetAndReturnSecurityAdvice: writing Log #3");
    }
}
