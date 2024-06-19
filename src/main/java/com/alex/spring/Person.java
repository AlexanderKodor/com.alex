package com.alex.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {
    private Pet pet;
    private  String surname;
    private int age;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("set surname");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("set age");
        this.age = age;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        System.out.println("set pet");
        this.pet = pet;
    }

    //@Autowired
    public Person(@Qualifier("catBean") Pet pet) {
        System.out.println("создался человек");
        this.pet = pet;
    }


//    public Person() {
//        System.out.println("создался человек");
//    }

    public void callYourPet(){
        System.out.println("Животное, голос.");
        pet.say();
    }
}
