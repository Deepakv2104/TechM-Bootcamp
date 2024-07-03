package com.app.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import com.app.repository.StudentRepository;
import com.app.model.Student;

@RestController
@RequestMapping("/select")
public class SelectController {
	@Autowired
    private StudentRepository studentRepository;

    @HystrixCommand(fallbackMethod = "getStudentByIdFallback")
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Integer id) {
        return studentRepository.findById(id);
    }

    @HystrixCommand(fallbackMethod = "getAllStudentsFallback")
    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentByIdFallback(Integer id) {
        return Optional.empty();
    }

    public List<Student> getAllStudentsFallback() {
        return Collections.emptyList();
    }
}