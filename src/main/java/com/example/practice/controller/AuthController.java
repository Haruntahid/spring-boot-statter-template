package com.example.practice.controller;

import com.example.practice.constant.ApiConstants;
import com.example.practice.model.dto.LoginDto;
import com.example.practice.model.dto.UserDto;
import com.example.practice.response.ApiResponse;
import com.example.practice.response.LoginResponse;
import com.example.practice.response.ServerResponse;
import com.example.practice.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(ApiConstants.API+ApiConstants.API_VERSION_V1)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService services;


    @PostMapping(ApiConstants.REGISTER_API)
    public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody UserDto dto) {
        services.register(dto);
        return ServerResponse.created("User registered successfully!");
    }

    @PostMapping(ApiConstants.LOGIN_API)
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginDto dto) {
        String token = services.verify(dto);
        return ServerResponse.login("Login successfully!", token);
    }
}
