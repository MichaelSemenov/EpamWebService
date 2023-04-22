package com.example.crudapplication.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private int id;
    private String name;
    public Person(){
        System.out.println("Создан человек для работы с сайтом!");
    }
}
