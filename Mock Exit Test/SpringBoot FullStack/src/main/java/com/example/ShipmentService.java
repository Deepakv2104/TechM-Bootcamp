package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    public Shipment getShipmentByTrackNo(String trackNo) {
        return shipmentRepository.findByTrackNo(trackNo);
    }

    public String deleteShipmentById(Integer shipId) {
        if (shipmentRepository.existsById(shipId)) {
            shipmentRepository.deleteById(shipId);
            return "The requested shipId-" + shipId + " got deleted";
        } else {
            throw new RuntimeException("Shipment with id " + shipId + " not found");
        }
    }
}

