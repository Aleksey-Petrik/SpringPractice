package com.practice.spring.rest.aop;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log
public class LoggerAspect {

    @Before(value = "execution(* com.practice.spring.rest.controller.RESTController.*(..))")
    public void getInMethodsBefore(JoinPoint joinPoint) {
        log.info(" Start method - " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.practice.spring.rest.controller.RESTController.*(..))")
    public void getOutMethodsAfter(JoinPoint joinPoint) {
        log.info("End method - " + joinPoint.getSignature().getName());
    }
}
