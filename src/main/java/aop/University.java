package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    List<Student> students = new ArrayList<>();

    public void addStudents(){
        Student st1 = new Student("Fox Alex", 4, 7.5);
        Student st2 = new Student("Foxi Alexia", 2, 8.3);
        Student st3 = new Student("Stels Fanni", 1, 9.1);
        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents(){
        System.out.println("Начало работы getStudents");
        System.out.println(students.get(3));
        System.out.println("information method getStudents: ");
        System.out.println(students);
        return students;
    }
}
