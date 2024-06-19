package com.alex.spring;

import org.springframework.stereotype.Component;

//@Component
public class Dog implements Pet{
    public Dog() {
        System.out.println("создалась собака");
    }

    public void init(){
        System.out.println("инит метод");
    }
    public void destroy(){
        System.out.println("дестрой метод");
    }

    @Override
    public void say() {
        System.out.println("гав-гав");
    }
}
