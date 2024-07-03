package com.app.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.repository.StudentRepository;
import com.app.model.Student;

@RestController
@RequestMapping("/insert")
public class InsertController {
    @Autowired
    private StudentRepository studentRepository;

    @HystrixCommand(fallbackMethod = "insertStudentFallback")
    @PostMapping("/")
    public Student insertStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }
    public Student insertStudentFallback(Student student) {
    	Student fallbackStudent=new Student();
    	fallbackStudent.setName("Fallback - Unable to save Student");
    	fallbackStudent.setClasss("Fallback value");
    	return fallbackStudent;
    }
}