package com.app.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import com.app.repository.StudentRepository;
import com.app.model.Student;

@RestController
@RequestMapping("/update")
public class UpdateController {
    @Autowired
    private StudentRepository studentRepository;

    @HystrixCommand(fallbackMethod = "updateRecordFallback")
    @PutMapping("/{id}")
    public String updateRecord(@PathVariable Integer id, @RequestBody Student updatedStudent) {
        Optional<Student> optionalRecord = studentRepository.findById(id);
        if (optionalRecord.isPresent()) {
        	Student existingRecord = optionalRecord.get();
            existingRecord.setName(updatedStudent.getName());
            existingRecord.setClasss(updatedStudent.getClasss());
            studentRepository.save(existingRecord);
            return "Record updated successfully";
        } else {
            throw new RecordNotFoundException("Record not found with id: " + id);
        }
    }

    public String updateRecordFallback(Integer id,Student updatedStudent) {
    	return "Fallback: Unable to update record with id " + id;
    }
}