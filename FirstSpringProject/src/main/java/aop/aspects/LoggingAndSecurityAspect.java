package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect//аннотация которая говорит о том что данный класс является аспектом
public class LoggingAndSecurityAspect {

    @Pointcut("execution(* aop.UniLibrary.*(..))")
    private void allMethodsFromUniLibrary() {
    }

    @Pointcut("execution(public void aop.UniLibrary.returnMagazine())")
    private void returnMagazineFromUniLibrary() {
    }

    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
    private void allMethodsExceptReturnMagazineFromUniLibrary() {
    }

    //-------------------------------------------------------------
    @Pointcut("execution(* aop.UniLibrary.get*())")
    private void allGetMethodsFromUniLibrary() {
    }

    @Pointcut("execution(* aop.UniLibrary.return*())")
    private void allReturnMethodsFromUniLibrary() {
    }

    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//Комбинирование поинткатов с помощью логических операторов
    private void allGetAndReturnMethodsFromUniLibrary() {
    }// || && !
    //-------------------------------------------------------------

    @Before("allGetMethodsFromUniLibrary()")
    public void beforeGetLoggingUniLibraryAdvice() {
        System.out.println("beforeGetLoggingUniLibraryAdvice: logging #1");
    }

    @Before("allReturnMethodsFromUniLibrary()")
    public void beforeReturnLoggingUniLibraryAdvice() {
        System.out.println("beforeReturnLoggingUniLibraryAdvice: logging #2");
    }

    @Before("allGetAndReturnMethodsFromUniLibrary()")
    public void beforeGetAndReturnLoggingUniLibraryAdvice() {
        System.out.println("beforeGetAndReturnLoggingUniLibraryAdvice: logging #3");
    }

    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
    public void beforeAllMethodsExceptReturnMagazineFromUniLibrary() {
        System.out.println("beforeGetAndReturnLoggingUniLibraryAdvice: logging #10");
    }

    //Pointcut - выражения, описывающее где должен применен Advice
    //execution - писываем шаблон метода
    //модификатор доступа?, возвращаемый тип или void!, класс?, имя метода(параметры)!, исключения которые выбрасывает метод exceptions?
    //если не указывать класс в котором метод, то программа будет брать все методы подходящие по шаблону
    //@Before("execution(public void aop.UniLibrary.getBook())")//данная аннотация задает возможность запуска метода перед ключевым, к примеру для логгирования
    @Before("execution(public void getBook())")//возьмутся все методы у которых имя начинается на get
    public void beforeGetBookAdvice() {
        System.out.println("\nbeforeGetBookAdvance : Попытка получить книгу");
    }

    //модификатор доступа не является обязательным, а звездочка в параметре возвращаемого типа говорит о том что тип может быть любой
    //execution(* *()) любой модификатор доступа, любой возвращаемый тип, любое имя метода, в любом классе может находится
    @Before("execution(* returnBook())")
    public void beforeReturnBookAdvice() {
        System.out.println("beforeGetBookAdvance : Попытка вернуть книгу");
    }

    //Если нужен метод с разными типами параметров, то ставим * getMagazine(*)
    //Если параметров несколько getMagazine(..) .. указывает любое количество параметров
    //getMagazine(String, ..)
    @Before("execution(public void getMagazine(aop.Magazine))")//сли тип не стандартный, то прописывается путь к классу
    public void beforeGetMagazineAdvice() {
        System.out.println("\nbeforeGetMagazineAdvice : Попытка получить журнал");
    }

}
