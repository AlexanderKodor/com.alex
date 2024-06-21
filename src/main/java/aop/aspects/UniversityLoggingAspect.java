package aop.aspects;

import aop.Student;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution(* getStudents())")
    public void beforeGetStudentsAdvice() {
        System.out.println("beforeGetStudentsAdvice: логируем перед получением списка студентов.");
    }

    //    @AfterReturning(pointcut = "execution(* getStudents())",
//    returning = "studentsAAA")
//    public void аfterReturningGetStudentsAdvice(List<Student> studentsAAA){
//        Student firstStudent = studentsAAA.get(0);
//        firstStudent.setNameSurname("Mr. " + firstStudent.getNameSurname());
//        firstStudent.setAvgGrade(firstStudent.getAvgGrade()+1);
//
//        System.out.println("аfterReturningGetStudentsAdvice: логируем получение списка студентов после рабботы метода.");
//    }
//    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exceptionAAA")
//    public void afterThrowingGetStudentsAdvice(Throwable exceptionAAA) {
//
//        System.out.println("afterThrowingGetStudentsAdvice: логируем выброс исключения " + exceptionAAA);
//    }

    @After("execution(* getStudents())")
    public void afterGetStudentsAdvice() {

        System.out.println("afterGetStudentsAdvice: логируем юбую работу метода.");
    }
}
