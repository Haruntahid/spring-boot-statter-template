package com.example.practice.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityPermitConfig {
    final String[] PERMIT_ALL = {
            "/api/v1/auth/**",
            "/api/v1/register",
            "/api/v1/login",
            "/swagger-ui/**",
            "/swagger-ui.html/**",
            "/swagger-resources/**",
            "/api-docs/**",
            "/v2/api-docs/**",
            "/v3/api-docs/**",
            "/api/v1/report",
            "/api/v1/data/external",
            "/h2-console/**"
    };
}
