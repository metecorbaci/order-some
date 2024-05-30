package com.ordersome.backend.constant;

import com.ordersome.backend.util.MessageBody;

import java.util.ArrayList;

public class ResponseMessages {
    public static ArrayList<MessageBody> LOGIN_SUCCESS(){
        ArrayList<MessageBody> messages = new ArrayList<>();
        messages.add(new MessageBody("Giriş başarılı.", "TR"));
        messages.add(new MessageBody("Login successful.", "EN"));
        return messages;
    }
    public static ArrayList<MessageBody> CREATE_SUCCESS(){
        ArrayList<MessageBody> messages = new ArrayList<>();
        messages.add(new MessageBody("Oluşturma işlemi başarılı.", "TR"));
        messages.add(new MessageBody("Creation successful.", "EN"));
        return messages;
    }
    public static ArrayList<MessageBody> USER_NOT_FOUND(){
        ArrayList<MessageBody> messages = new ArrayList<>();
        messages.add(new MessageBody("Kullanıcı bulunamadı.", "TR"));
        messages.add(new MessageBody("User not found.", "EN"));
        return messages;
    }

    public static ArrayList<MessageBody> GET_SUCCESS(){
        ArrayList<MessageBody> messages = new ArrayList<>();
        messages.add(new MessageBody("Getirme işlemi başarılı.", "TR"));
        messages.add(new MessageBody("Get successful.", "EN"));
        return messages;
    }

    public static ArrayList<MessageBody> NOT_FOUND(){
        ArrayList<MessageBody> messages = new ArrayList<>();
        messages.add(new MessageBody("Bulunamadı.", "TR"));
        messages.add(new MessageBody("Not found.", "EN"));
        return messages;
    }

    public static ArrayList<MessageBody> REGISTER_SUCCESS(){
        ArrayList<MessageBody> messages = new ArrayList<>();
        messages.add(new MessageBody("Kayıt başarılı.", "TR"));
        messages.add(new MessageBody("Registration successful.", "EN"));
        return messages;
    }

    public static ArrayList<MessageBody> USER_ALREADY_EXISTS(){
        ArrayList<MessageBody> messages = new ArrayList<>();
        messages.add(new MessageBody("Kullanıcı zaten mevcut.", "TR"));
        messages.add(new MessageBody("User already exists.", "EN"));
        return messages;
    }

    public static ArrayList<MessageBody> USER_REGISTER_DATA_NOT_FOUND(){
        ArrayList<MessageBody> messages = new ArrayList<>();
        messages.add(new MessageBody("Kullanıcı bilgileri eksik.", "TR"));
        messages.add(new MessageBody("User information is missing.", "EN"));
        return messages;
    }

    public static ArrayList<MessageBody> ORDER_CREATED() {
        ArrayList<MessageBody> messages = new ArrayList<>();
        messages.add(new MessageBody("Sipariş oluşturuldu.", "TR"));
        messages.add(new MessageBody("Order created.", "EN"));
        return messages;
    }

    public static ArrayList<MessageBody> FOOD_NOT_FOUND() {
        ArrayList<MessageBody> messages = new ArrayList<>();
        messages.add(new MessageBody("Yemek bulunamadı.", "TR"));
        messages.add(new MessageBody("Food not found.", "EN"));
        return messages;
    }

    public static ArrayList<MessageBody> ORDER_NOT_FOUND() {
        ArrayList<MessageBody> messages = new ArrayList<>();
        messages.add(new MessageBody("Sipariş bulunamadı.", "TR"));
        messages.add(new MessageBody("Order not found.", "EN"));
        return messages;
    }

    public static ArrayList<MessageBody> ORDER_ALREADY_EXISTS() {
        ArrayList<MessageBody> messages = new ArrayList<>();
        messages.add(new MessageBody("Sipariş zaten mevcut.", "TR"));
        messages.add(new MessageBody("Order already exists.", "EN"));
        return messages;
    }

    public static ArrayList<MessageBody> FOOD_ALREADY_EXISTS() {
        ArrayList<MessageBody> messages = new ArrayList<>();
        messages.add(new MessageBody("Yemek zaten mevcut.", "TR"));
        messages.add(new MessageBody("Food already exists.", "EN"));
        return messages;
    }
}

