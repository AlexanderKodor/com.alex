package com.alex.spring;

import org.springframework.stereotype.Component;

//@Component("catBean")
public class Cat implements Pet{
    public Cat() {
        System.out.println("создалась кошка.");
    }

    @Override
    public void say() {
        System.out.println("мяу-мяу");
    }
}
