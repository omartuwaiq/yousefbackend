package com.example.FoodDelivery.model.repository;

import com.example.FoodDelivery.model.entities.Driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
}
