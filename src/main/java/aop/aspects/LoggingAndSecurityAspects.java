package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspects {

    @Pointcut("execution(* aop.UniLibrary.*())")
    private void allMethods(){}

    @Pointcut("execution(* aop.UniLibrary.returnMagazine())")
    private void returnMagazineMethod(){}

    @Pointcut("allMethods() && !returnMagazineMethod()")
    private void allMethodsWithoutreturnMagazineMethod(){}

    @Before("allMethodsWithoutreturnMagazineMethod()")
    public void beforeGetLogging(){
        System.out.println("Логирование всего кроме returnMagazineMethod");
    }




//    @Pointcut("execution(* aop.UniLibrary.get*())")
//    private void allGetMethodsUniLibrary(){}
//
//    @Before("allGetMethodsUniLibrary()")
//    public void beforeGetLogging(){
//        System.out.println("Логирование перед гет методами");
//    }
//
//    @Pointcut("execution(* aop.UniLibrary.return*())")
//    private void allReturnMethods(){}
//
//    @Before("allReturnMethods()")
//    public void beforeReturnLogging(){
//        System.out.println("Логирование перед ретёрн методами");
//    }
//
//    @Pointcut("allGetMethodsUniLibrary() || allReturnMethods()")
//    private void allGetAndReturnMethods(){}
//
//    @Before("allGetAndReturnMethods()")
//    public void beforeGetAndReturnLogging(){
//        System.out.println("Логирование перед гет или ретёрн методами");
//    }








//    @Pointcut("execution(* get*())")
//    private void allGetMethods(){}
//
//    @Before(value = "allGetMethods()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("Попытка получить книгу или журнал.");
//    }
//    @Before("execution(* returnBook())")
//    public void beforeReturnBookAdvice(){
//        System.out.println("-Попытка вернуть книгу.");
//    }
//    @Before("allGetMethods()")
//    public void beforeSecurityAdvice(){
//        System.out.println("Осуществляется проверка прав на получение.");
//    }
}
