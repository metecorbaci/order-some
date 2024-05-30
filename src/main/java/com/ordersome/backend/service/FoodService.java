package com.ordersome.backend.service;

import com.ordersome.backend.constant.ResponseMessages;
import com.ordersome.backend.dto.FoodResDto;
import com.ordersome.backend.dto.FoodReqDto;
import com.ordersome.backend.model.Food;
import com.ordersome.backend.repository.FoodRepository;
import com.ordersome.backend.util.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public ResponseEntity createFood(FoodReqDto foodReqDto) {
        try {
            Food food = new Food(foodReqDto.getName(), foodReqDto.getPrice());
            var savedFood = foodRepository.save(food);
            return ResponseBody.sendBody(ResponseMessages.CREATE_SUCCESS(), new FoodResDto(savedFood.getName(),savedFood.getPrice()), HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return ResponseBody.send(ResponseMessages.FOOD_ALREADY_EXISTS(), null, HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            System.out.println(e);
            return ResponseBody.send(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Food[]> getAllFoods() {
        try {
            List<Food> foods = foodRepository.findAll();
            List<FoodResDto> foodResDtos = new ArrayList<>();
            if(foods.isEmpty()){
                return ResponseBody.sendBody(ResponseMessages.NOT_FOUND(), null, HttpStatus.NOT_FOUND);
            }
            foods.forEach(food -> {
                foodResDtos.add(new FoodResDto(food.getName(), food.getPrice()));
            });

            return ResponseBody.sendBody(ResponseMessages.GET_SUCCESS(), foodResDtos, HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e);
            return ResponseBody.send(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
