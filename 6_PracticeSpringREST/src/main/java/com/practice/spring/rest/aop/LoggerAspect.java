package com.practice.spring.rest.aop;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log
public class LoggerAspect {

    @Before(value = "execution(* com.practice.spring.rest.controller.RESTController.*(..))")
    public void getInMethod(JoinPoint joinPoint) {
        log.info("In method - " + joinPoint.getSignature().getName());
    }

}
