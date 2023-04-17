package ru.alishev.springcourse;

import org.springframework.stereotype.Component;

                        //Замена обычного бина, название id Bean, если null, то id = roc
public class RockMusic implements Music{
    private String name;
    @Override
    public String getSon() {
        return "ТЕСТОВОЕ ЗНАЧЕНИЕ!";
    }

    public void setName(String name) {
        this.name = name;
    }
}
