package aop.aspects;

import aop.Student;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
        Student firstStudent = students.get(0);
        firstStudent.setNameSurname("mr." + firstStudent.getNameSurname());
        firstStudent.setCourse(firstStudent.getCourse() + 1);
        System.out.println("beforeGetStudentsLoggingAdvice: логируем получение списка студентов после метода getStudents.");
    }
}
