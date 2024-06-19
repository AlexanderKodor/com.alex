package com.alex.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        Pet pet = context.getBean("myPet", Pet.class);
        pet.say();
//        Pet pet2 = context.getBean("myPet", Pet.class);
//        System.out.println(pet.equals(pet2));



        context.close();
    }
}
