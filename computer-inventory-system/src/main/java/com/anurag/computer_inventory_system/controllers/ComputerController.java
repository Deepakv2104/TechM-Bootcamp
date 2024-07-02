package com.anurag.computer_inventory_system.controllers;

import org.springframework.web.bind.annotation.*;

import com.anurag.computer_inventory_system.entities.Computer;
import com.anurag.computer_inventory_system.services.ComputerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")	
@RequestMapping("inventory")
public class ComputerController {

    @Autowired
    ComputerService computerService;

    @GetMapping("allComputers")
    public ResponseEntity<List<Computer>> getAllComputers() {
        return computerService.getAllComputers();
    }

    @GetMapping("brand/{brand}")
    public ResponseEntity<List<Computer>> getComputersByBrand(@PathVariable String brand) {
        return computerService.getComputersByBrand(brand);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Computer> getComputerById(@PathVariable Long id) {
        return computerService.getComputerById(id);
    }

    @PostMapping("add")
    public ResponseEntity<String> addComputer(@RequestBody Computer computer) {
        return computerService.addComputer(computer);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<String> updateComputer(@PathVariable Long id, @RequestBody Computer computer) {
        computer.setId(id);
        return computerService.updateComputer(computer);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteComputer(@PathVariable Long id) {
        return computerService.deleteComputer(id);
    }
}