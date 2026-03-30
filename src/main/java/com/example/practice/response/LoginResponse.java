package com.example.practice.response;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class LoginResponse {
    private int status;
    private String result;
    private String message;
    private String token;
}
