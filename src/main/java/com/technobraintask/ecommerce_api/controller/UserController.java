package com.technobraintask.ecommerce_api.controller;

import com.technobraintask.ecommerce_api.dto.LoginDto;
import com.technobraintask.ecommerce_api.dto.RegisterDto;
import com.technobraintask.ecommerce_api.models.Product;
import com.technobraintask.ecommerce_api.models.User;
import com.technobraintask.ecommerce_api.response.LoginResponse;
import com.technobraintask.ecommerce_api.security.service.JwtService;
import com.technobraintask.ecommerce_api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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


    @Operation(summary = "register new user")
    @ApiResponses(
            value = {@ApiResponse(responseCode = "200", description = "create new user", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = User.class))}),
                    @ApiResponse(responseCode = "500", description = "internal server error", content = @Content),
                    @ApiResponse(responseCode = "403",description = "bad credentials",content = @Content),
                    @ApiResponse(responseCode = "404",description = "not found",content = @Content)
            }
    )
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterDto registerDto) {
        User user = userService.createUser(registerDto);
        System.out.println(user);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "login user")
    @ApiResponses(
            value = {@ApiResponse(responseCode = "200", description = "sign in user", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = User.class))}),
                    @ApiResponse(responseCode = "500", description = "internal server error", content = @Content),
                    @ApiResponse(responseCode = "403",description = "bad credentials",content = @Content),
                    @ApiResponse(responseCode = "404",description = "not found",content = @Content)
            }
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginDto loginDto) {
        User user = userService.loginUser(loginDto);
        String jwtToken = jwtService.generateToken(user);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getJwtExpiration());

        return ResponseEntity.ok(loginResponse);
    }
}
