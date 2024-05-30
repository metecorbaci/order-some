package com.ordersome.backend.dto;

import java.util.Date;

public class OrderResDto {

    private String user_name;
    private String email;
    private String food_name;
    private Double food_price;
    private Date order_date;

    public OrderResDto(String email, String user_name, String food_name, Double food_price, Date order_date) {
        this.email = email;
        this.user_name = user_name;
        this.food_name = food_name;
        this.food_price = food_price;
        this.order_date = order_date;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public Double getFood_price() {
        return food_price;
    }

    public void setFood_price(Double food_price) {
        this.food_price = food_price;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
