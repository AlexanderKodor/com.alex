package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspects {

//    @Pointcut("execution(* aop.UniLibrary.*())")
//    private void allMethods(){}
//
//    @Pointcut("execution(* aop.UniLibrary.returnMagazine())")
//    private void returnMagazineMethod(){}
//
//    @Pointcut("allMethods() && !returnMagazineMethod()")
//    private void allMethodsWithoutreturnMagazineMethod(){}
//
//    @Before("allMethodsWithoutreturnMagazineMethod()")
//    public void beforeGetLogging(){
//        System.out.println("Логирование всего кроме returnMagazineMethod");
//    }




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










    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());

        if(methodSignature.getName().equals("addBook")){
            Object[] arguments = joinPoint.getArgs();
            for(Object o:arguments){
                if(o instanceof Book){
                    Book inBook = (Book)o;
                    System.out.println("Информация о книге: автор - " + inBook.getAuthor());
                    System.out.println("Информация о книге: название - " + inBook.getName());
                    System.out.println("Информация о книге: год публикации - " + inBook.getYersOfPublication());
                } if(o instanceof String){
                    System.out.println("Книгу в библиотеку добавляет - " + o);
                }
            }
        }


        System.out.println("Логирование попытки получить книгу или журнал.");
        System.out.println("-----------------------------------");
    }
//    @Before("execution(* returnBook())")
//    public void beforeReturnBookAdvice(){
//        System.out.println("-Попытка вернуть книгу.");
//    }

}
