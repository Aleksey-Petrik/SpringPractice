package com.practice.hibernate.aspects;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class TestAspect {

    @Before("execution(* com.practice.hibernate.service.ServiceHibernate.addEmployee(..))")
    public void beforeAddEmployee(JoinPoint joinPoint) {
        log.info("Попытка добавить работника {}", joinPoint.getArgs()[0]);
    }

}