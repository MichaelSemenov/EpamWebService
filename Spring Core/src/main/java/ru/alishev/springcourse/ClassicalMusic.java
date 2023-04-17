package ru.alishev.springcourse;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;


public class ClassicalMusic implements Music{
    private String name;
    public ClassicalMusic() {};
    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }
    @Override
    public String getSon() {
        return "ТЕСТОВАЯ СТРОКА";
    }

    public void setName(String name) {
        this.name = name;
    }
    @PreDestroy
    public void doMyDestroy(){
        System.out.println("Doing my destroyer!");
    }
    @PostConstruct
    public void doMyInit(){
        System.out.println("Doing my initialization!");
    }
}
