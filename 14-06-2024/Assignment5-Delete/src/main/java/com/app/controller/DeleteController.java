package com.app.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.repository.StudentRepository;
import com.app.model.Student;

@RestController
@RequestMapping("/delete")
public class DeleteController {
    @Autowired
    private StudentRepository studentRepository;

    @HystrixCommand(fallbackMethod = "deleteRecordByIdFallback")
    @DeleteMapping("/{id}")
    public String deleteRecordById(@PathVariable Integer id) {
        studentRepository.deleteById(id);
        return "Record deleted successfully";
    }

    public String deleteRecordByIdFallback(Integer id) {
        return "Fallback: Unable to delete record with id " + id;
    }

    @HystrixCommand(fallbackMethod = "deleteAllRecordsFallback")
    @DeleteMapping("/")
    public String deleteAllRecords() {
        studentRepository.deleteAll();
        return "All records deleted successfully";
    }
    
    public String deleteAllRecordsFallback() {
    	return "Fallback: Unable to delete all records";
    }
}
