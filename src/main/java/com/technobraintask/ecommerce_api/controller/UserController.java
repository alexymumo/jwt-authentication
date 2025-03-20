package com.technobraintask.ecommerce_api.controller;

import com.technobraintask.ecommerce_api.dto.LoginDto;
import com.technobraintask.ecommerce_api.dto.RegisterDto;
import com.technobraintask.ecommerce_api.models.User;
import com.technobraintask.ecommerce_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDto registerDto) {
        User user = userService.createUser(registerDto);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDto loginDto) {
        return null;
    }

    @GetMapping("/test")
    public String TestController() {
        return "Test endpoint";
    }
}
