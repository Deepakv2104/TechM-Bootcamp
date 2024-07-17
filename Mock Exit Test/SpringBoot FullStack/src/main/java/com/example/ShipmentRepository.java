package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {

    @Query("SELECT s FROM Shipment s WHERE s.trackNo = :trackNo")
    Shipment findByTrackNo(@Param("trackNo") String trackNo);
}

