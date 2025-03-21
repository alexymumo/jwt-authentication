package com.technobraintask.ecommerce_api.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private long expiresIn;
}
