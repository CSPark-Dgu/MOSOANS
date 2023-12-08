package com.example.finalexam_2021;

public class Person {

    String name;
    int phone;
    String email;

    public Person(String name, int phone, String email){
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public int getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }
}
