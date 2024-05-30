package com.ordersome.backend.dto;


public class FoodResDto {

    private String name;
    private Double price;

    public FoodResDto() {
        super();
    }

    public FoodResDto(String name, Double price) {
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
