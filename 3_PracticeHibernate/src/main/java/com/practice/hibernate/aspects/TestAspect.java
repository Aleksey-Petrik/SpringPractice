package com.practice.hibernate.aspects;

import com.practice.hibernate.entity.Employee;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class TestAspect {

    @Before("execution(* com.practice.hibernate.service.ServiceHibernate.addEmployee(..))")
    public void beforeAddEmployee(JoinPoint joinPoint) {
        log.info("Попытка добавить работника {}", joinPoint.getArgs()[0]);
    }

    @After("execution(* com.practice.hibernate.service.ServiceHibernate.addEmployee(..))")
    public void afterAddEmployee(JoinPoint joinPoint) {
        log.info("Добавлен новый работник работника {}", joinPoint.getArgs()[0]);
    }

    @Before("execution(* com.practice.hibernate.service.ServiceHibernate.deleteEmployee(..))")
    public void beforeDeleteEmployeeAdvice(JoinPoint joinPoint) {
        log.info("Попытка удалить работника {}", joinPoint.getArgs()[0]);
    }

    @After("execution(* com.practice.hibernate.service.ServiceHibernate.deleteEmployee(..))")
    public void afterDeleteEmployeeAdvice(JoinPoint joinPoint) {
        log.info("Из базы успешно удален работник {}", joinPoint.getArgs()[0]);
    }

    @Around("execution(* com.practice.hibernate.service.ServiceHibernate.getEmployee(..))")
    public Employee aroundTestTran(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        log.info("Попытка из базы взять работника с ID - {}", args[1]);
        Session session = (Session) args[0];
        session.getTransaction().begin();
        log.info("State transaction - {}", session.isOpen() ? "OPEN" : "CLOSE");
        Employee employee = (Employee) proceedingJoinPoint.proceed();
        session.getTransaction().commit();
        log.info("Return object - {}", employee);
        log.info("State transaction - {}", session.isOpen() ? "OPEN" : "CLOSE");
        return employee;
    }

}