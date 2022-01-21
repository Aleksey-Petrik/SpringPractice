package com.practice.spring.mvc_hibernate_aop.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class AspectLogging {

    @Before("execution(* com.practice.spring.mvc_hibernate_aop.dao.EmployeeDAOImpl.saveEmployee(..))")
    public void beforeSaveEmployee(JoinPoint joinPoint) {
        Object[] arguments = joinPoint.getArgs();
        log.info("Попытка добавить рабочего {}", arguments[0]);
    }

    @Before("execution(* com.practice.spring.mvc_hibernate_aop.dao.EmployeeDAOImpl.deleteEmployee(..))")
    public void beforeDeleteEmployee(JoinPoint joinPoint) {
        Object[] arguments = joinPoint.getArgs();
        log.info("Попытка удалить рабочего {}");
    }
}
