package com.ordersome.backend.dto;

import jakarta.validation.constraints.NotNull;

public class OrderReqDto {

    @NotNull(message = "foodName cannot be null")
    private String foodName;
    private String userMail;

    public OrderReqDto(String foodName, String userMail) {
        this.foodName = foodName;
        this.userMail = userMail;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
}
