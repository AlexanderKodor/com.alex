package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {
    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("aroundReturnBookLoggingAspect: В библиотеку пытаются книгу.");
        Object targetMethodResult = null;
        try{
            targetMethodResult = proceedingJoinPoint.proceed();}
        catch (Exception e){
            System.out.println("Было выброшено исключение(залоггировали) " + e);
//            targetMethodResult = "Неизвестное название книги";
//            пробрасываем исключени дальше для обработки
            throw e;
        }

        System.out.println("aroundReturnBookLoggingAspect: В библиотеку успешно возвращают книгу.");
        return targetMethodResult;
    }
}
