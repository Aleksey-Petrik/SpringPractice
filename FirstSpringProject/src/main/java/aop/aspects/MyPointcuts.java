package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyPointcuts {

    /*
    Можно логически разбивать классы аспекты, логирование отдельно, проверка прав доступа так же отдельно
     */

    @Pointcut("execution(* get*())")//создание ссылки на advices, для быстрого изменения шаблона advices
    public void allGetMethods() {//если сделать public, то ссылка будет доступна и для других advices
    }

    @Pointcut("execution(* add*(..))")
    public void allAddMethods() {
    }

}
