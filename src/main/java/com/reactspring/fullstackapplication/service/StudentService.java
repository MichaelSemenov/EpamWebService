package com.reactspring.fullstackapplication.service;

import com.reactspring.fullstackapplication.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudent();
}
