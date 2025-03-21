package com.technobraintask.ecommerce_api.dto;


import lombok.Data;

@Data
public class RegisterDto {
    private String fullName;
    private String email;
    private String phone;
    private String password;
}
