package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurtainRepository extends JpaRepository<Curtain, Integer> {

    @Query("SELECT c FROM Curtain c WHERE c.price > :price")
    List<Curtain> findByPriceGreaterThan(@Param("price") int price);

    @Query("SELECT c FROM Curtain c WHERE c.brand = :brand")
    List<Curtain> findByBrand(@Param("brand") String brand);
}


