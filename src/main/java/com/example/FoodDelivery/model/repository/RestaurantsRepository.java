package com.example.FoodDelivery.model.repository;

import com.example.FoodDelivery.model.entities.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantsRepository extends JpaRepository <Restaurants, Integer> {
}
