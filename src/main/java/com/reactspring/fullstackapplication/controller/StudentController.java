package com.reactspring.fullstackapplication.controller;

import com.reactspring.fullstackapplication.model.Student;
import com.reactspring.fullstackapplication.service.StudentService;
import com.reactspring.fullstackapplication.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentServiceImp studentServiceImp) {
        this.studentService = studentServiceImp;
    }

    @PostMapping("/add")
    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return "New student is added!";
    }
    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }
}
