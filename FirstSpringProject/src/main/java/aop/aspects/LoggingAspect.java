package aop.aspects;

import aop.Magazine;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1) // аннотация, которая управляет очередностью классов аспектов
public class LoggingAspect {

    @Before("aop.aspects.MyPointcuts.allGetMethods()")
    public void beforeGetLoggingAdvice() {
        System.out.println("1 - beforeGetLoggingAdvice: запись в лог, попытка взять книгу/журнал");
    }

    //JoinPoint joinPoint - предоставляет информацию о сигнатуре и параметрах метода
    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("MethodSignature = " + methodSignature);
        System.out.println("getMethod = " + methodSignature.getMethod());
        System.out.println("getReturnType = " + methodSignature.getReturnType());
        System.out.println("getName = " + methodSignature.getName());

        if (methodSignature.getName().equals("addMagazine")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object argument : arguments) {
                if (argument instanceof Magazine) {
                    Magazine magazine = (Magazine) argument;
                    System.out.println("Information magazine - " + magazine.getName());
                } else {
                    System.out.println("Magazine added - " + argument);
                }
            }
        }

        System.out.println("1 - beforeAddLoggingAdvice: запись в лог, попытка взять книгу/журнал");
    }

}
