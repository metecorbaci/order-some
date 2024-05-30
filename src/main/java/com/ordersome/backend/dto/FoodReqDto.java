package com.ordersome.backend.dto;

import jakarta.validation.constraints.NotNull;

public class FoodReqDto {
    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "Price is required")
    private Double price;

    public FoodReqDto() {
        super();
    }

    public FoodReqDto(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
