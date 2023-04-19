package com.example.fulllprojectspring.main.Controller.main;

import com.example.fulllprojectspring.main.Controller.Controller.SpringController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SpringController.class})
public class FulllProjectSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(FulllProjectSpringApplication.class, args);
    }

}
