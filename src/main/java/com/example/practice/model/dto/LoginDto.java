package com.example.practice.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {
    @NotBlank(message = "Username Require")
    private String username;

    @NotBlank(message = "Password Require")
    private String password;
}
