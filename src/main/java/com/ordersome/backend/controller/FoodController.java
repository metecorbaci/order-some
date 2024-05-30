package com.ordersome.backend.controller;

import com.ordersome.backend.dto.FoodReqDto;
import com.ordersome.backend.model.Food;
import com.ordersome.backend.service.FoodService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
// Swagger da gözükecek olan tag'in adı ve açıklaması
@Tag(name = "Food", description = "Food APIS")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping("/create")
    public ResponseEntity createFood(@RequestBody FoodReqDto foodReqDto) {
        return foodService.createFood(foodReqDto);
    }

    @GetMapping("/all")
    public ResponseEntity<Food[]> getAllFoods() {
        return foodService.getAllFoods();
    }
}
