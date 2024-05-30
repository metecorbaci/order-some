package com.ordersome.backend.repository;

import com.ordersome.backend.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {
    Food findByName(String name);
}
