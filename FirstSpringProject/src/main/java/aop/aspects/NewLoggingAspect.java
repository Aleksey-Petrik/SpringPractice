package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {
    /*
        @Around() - аннотация с помощью которой можно
        произвести какие-либо действия до целевого метода,
        или после.
        Получить результат выполнения метода и изменить его.
        Отловить исключение и что-то с этим сделать.
    */
    @Around("execution(public String returnBookName(String))")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу.");

        long begin = System.currentTimeMillis();
        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (ArithmeticException e) {
            System.out.println("aroundReturnBookLoggingAdvice: было поймано исключение " + e);
            targetMethodResult = "Неизвестное название книги.";
        }
        long end = System.currentTimeMillis();

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу.");
        System.out.println("aroundReturnBookLoggingAdvice: метод returnBookName выполнил за - " + (end - begin));
        return targetMethodResult;
    }

}
