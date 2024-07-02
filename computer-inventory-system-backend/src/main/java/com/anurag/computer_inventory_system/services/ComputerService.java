package com.anurag.computer_inventory_system.services;

import com.anurag.computer_inventory_system.dao.ComputerDao;
import com.anurag.computer_inventory_system.entities.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {

    @Autowired
    ComputerDao computerDao;

    public ResponseEntity<List<Computer>> getAllComputers() {
        try {
            List<Computer> computers = computerDao.findAll();
            return new ResponseEntity<>(computers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Computer>> getComputersByBrand(String brand) {
        try {
            List<Computer> computers = computerDao.findByBrand(brand);
            return new ResponseEntity<>(computers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Computer> getComputerById(Long id) {
        try {
            Optional<Computer> computer = computerDao.findById(id);
            return computer.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> addComputer(Computer computer) {
        try {
            computerDao.save(computer);
            return new ResponseEntity<>("Computer added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to add computer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

 // In ComputerService.java
    public ResponseEntity<String> updateComputer(Computer computer) {
        try {
            Optional<Computer> existingComputerOptional = computerDao.findById(computer.getId());
            if (existingComputerOptional.isPresent()) {
                computerDao.save(computer);
                return new ResponseEntity<>("Computer updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Computer not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to update computer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<String> deleteComputer(Long id) {
        try {
            Optional<Computer> existingComputerOptional = computerDao.findById(id);
            if (existingComputerOptional.isPresent()) {
                computerDao.deleteById(id);
                return new ResponseEntity<>("Computer deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Computer not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to delete computer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}