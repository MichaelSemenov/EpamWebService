package com.example.fulllprojectspring.main.Controller.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
@RequestMapping("/message")
public class SpringController {
    @GetMapping("/test")
    public String helloInfo(){
        return "ПРИВЕТ, МИР";
    }
    @RequestMapping("/hello")
    public String HELLO (){
        return "HELLO";
    }
    @GetMapping("/init")
    public String nameSurname(HttpServletRequest request){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println("Ваша введенная информация: " + name + " " + surname);
        return "Добро пожаловать, " + name + " " + surname;
    }
    @GetMapping("/init1")
    public String nameSurname1(@RequestParam(value = "name" , required = false) String name,
                               @RequestParam(value = "surname", required = false) String surname){
        return "Добро пожаловать, " + name + " " + surname;
    }
}
