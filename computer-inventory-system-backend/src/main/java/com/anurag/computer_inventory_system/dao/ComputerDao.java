package com.anurag.computer_inventory_system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anurag.computer_inventory_system.entities.Computer;

@Repository
public interface ComputerDao extends JpaRepository<Computer, Long> {
    List<Computer> findByBrand(String brand);
    Computer findById(long id); // Method to find a computer by its ID
}