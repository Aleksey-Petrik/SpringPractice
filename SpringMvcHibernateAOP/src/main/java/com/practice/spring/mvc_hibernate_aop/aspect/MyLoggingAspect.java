package com.practice.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {

    @Around("execution(* com.practice.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        /*
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String nameMethod = methodSignature.getName();
        */
        String nameMethod = proceedingJoinPoint.getSignature().getName();
        System.out.println("Begin of " + nameMethod);
        Object targetMethodResult = proceedingJoinPoint.proceed();
        System.out.println("End of " + nameMethod);
        return targetMethodResult;
    }
}
