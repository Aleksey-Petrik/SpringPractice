package com.practice.spring.aop.practice_after_returning.aspects;

import com.practice.spring.aop.practice_after_returning.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class UniversityLoggingAspect {
    private final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Before("execution(* addStudents(..))")
    public void beforeAddStudentLoggingAdvice(JoinPoint joinPoint) {
        Student student = (Student) joinPoint.getArgs()[0];
        logger.info("beforeAddStudentLoggingAdvice: попытка добавить студента {}", student);
    }

    @Before("execution (* getStudents(..))")
    public void beforeGetStudentsLoggingAdvice() {
        logger.info("beforeGetStudentsLoggingAdvice: логгируем получение списка студентов.");
    }

    /*
     * @AfterReturning - выполняется после успешного завершения целевого метода, можно изменять возвращаемый целевым методом результат,
     * но не рекомендуется
     * */
    @AfterReturning(pointcut = "execution (* getStudents(..))", returning = "students")
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) {
        logger.info("afterReturningGetStudentsLoggingAdvice: логгируем получение списка студентов, после работы getStudents.");
        Student student = students.get(0);
        student.setName("mr." + student.getName());
    }

    /*
     * @AfterThrowing - выполняется после аварийного завершения целевого метода
     * */
    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception) {
        logger.info("Было поймано исключение " + exception.getMessage());
    }

    /*
     * @AfterThrowing - выполняется после успешного или аварийного завершения целевого метода
     * */
    @After("execution(* getStudents(..))")
    public void afterGetStudentsLoggingAdvice() {
        logger.info("afterGetStudentsLoggingAdvice : логгирование после завершения метода getStudents");
    }

    /*
     * @Around - выполняется до и после выполнения целевого метода, но контролировать запуск целевого метода лежит на
     * плечах разработчика
     * */
    @Around("execution(* addStudents(..))")
    public Object aroundAddStudentsLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Student student = (Student) proceedingJoinPoint.getArgs()[0];
        logger.info("aroundAddStudentsLoggingAdvice: Попытка добавить студента {}", student);
        long timeBegin = System.currentTimeMillis();
        Student targetMethodResult = (Student) proceedingJoinPoint.proceed();
        long timeEnd = System.currentTimeMillis();
        logger.info("aroundAddStudentsLoggingAdvice: студент успешно добавлен {} the time - {}", targetMethodResult, timeEnd - timeBegin);
        return targetMethodResult;
    }
}
