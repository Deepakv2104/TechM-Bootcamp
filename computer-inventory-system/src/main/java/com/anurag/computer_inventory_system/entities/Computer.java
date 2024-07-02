package com.anurag.computer_inventory_system.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "computers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String brand;
    private String model;
    private String serialNumber;
    private String cpu;
    private int ram; // in GB
    private int storage; // in GB
    private String storageType; // e.g., SSD, HDD
    private String gpu;
    private String operatingSystem;
    private String formFactor; // e.g., Desktop, Laptop
    private boolean isAvailable;
    private LocalDate purchaseDate;
    private LocalDate warrantyExpiryDate;
}