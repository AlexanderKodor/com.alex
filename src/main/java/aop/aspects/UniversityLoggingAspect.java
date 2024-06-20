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

    @Before("execution(* getStudents())")
    public void beforeGetStudentsAdvice(){
        System.out.println("beforeGetStudentsAdvice: логируем перед получением списка студентов.");
    }

    @AfterReturning(pointcut = "execution(* getStudents())",
    returning = "studentsAAA")
    public void аfterReturningGetStudentsAdvice(List<Student> studentsAAA){
        Student firstStudent = studentsAAA.get(0);
        firstStudent.setNameSurname("Mr. " + firstStudent.getNameSurname());
        firstStudent.setAvgGrade(firstStudent.getAvgGrade()+1);

        System.out.println("аfterReturningGetStudentsAdvice: логируем получение списка студентов после рабботы метода.");
    }
}
