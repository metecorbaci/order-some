package com.ordersome.backend.dto;

import jakarta.validation.constraints.NotNull;

public class LoginReqDto {

    @NotNull(message = "Email is required")
    private String email;
    @NotNull(message = "Password is required")
    private String password;

    public LoginReqDto() {
    }

    public LoginReqDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
}
