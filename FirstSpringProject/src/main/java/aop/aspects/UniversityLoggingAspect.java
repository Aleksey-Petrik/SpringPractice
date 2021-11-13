package aop.aspects;

import aop.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
    //@Before - вызов метода до целевого метода
    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice() {
        System.out.println("beforeGetStudentsLoggingAdvice: логируем получение списка студентов перед методом getStudents.");
    }

    //@AfterReturning - вызов метода после целевого метода
    //@AfterReturning("execution(* getStudents())")
    //public void afterReturningGetStudentsLoggingAdvice() {
    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")//можно изменить возвращаемый результат методом
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) {
        System.out.println("Начало afterReturningGetStudentsLoggingAdvice:");
        Student firstStudent = students.get(0);
        firstStudent.setNameSurname("mr." + firstStudent.getNameSurname());
        firstStudent.setCourse(firstStudent.getCourse() + 1);
        System.out.println("beforeGetStudentsLoggingAdvice: логируем получение списка студентов после метода getStudents.");
    }

    //@AfterThrowing - вызвать метод если целевой метод завершился с ошибкой, то есть exceptions
    //@AfterThrowing("execution(* getStudents())")
    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exceptions")//Если необходима информация о том какое исключение было выкинуто
    public void afterThrowingGetStudentsLoggingAdvice(JoinPoint joinPoint, Throwable exceptions) {
        System.out.println("afterThrowingGetStudentsLoggingAdvice: логируем выброс исключения - (" + joinPoint.toString() + ") - " + exceptions);
    }

    //@After() данная аннотация сработает при нормальном завершении метода и если метод завершится с ошибкой, то есть выкинет исключение
    //невозможно получить доступ к исключению которое выбросил метод
    //невозможно получить доступ к возвращаемому методом результату
    @After("execution(* getStudents())")
    //public void afterGetStudentsLoggingAdvice(JoinPoint joinPoint) {
    public void afterGetStudentsLoggingAdvice() {
        System.out.println("afterGetStudentsLoggingAdvice: логируем нормальное окончание работы метода или выброс исключения.");
    }

}
