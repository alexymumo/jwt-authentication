package com.technobraintask.ecommerce_api.controller;

import com.technobraintask.ecommerce_api.dto.LoginDto;
import com.technobraintask.ecommerce_api.dto.RegisterDto;
import com.technobraintask.ecommerce_api.models.User;
import com.technobraintask.ecommerce_api.response.LoginResponse;
import com.technobraintask.ecommerce_api.security.service.JwtService;
import com.technobraintask.ecommerce_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;



    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDto registerDto) {
        User user = userService.createUser(registerDto);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDto loginDto) {
        User user = userService.loginUser(loginDto);
        String jwtToken = jwtService.generateToken(user);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getJwtExpiration());

        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/test")
    public String TestController() {
        return "Test endpoint";
    }
}
