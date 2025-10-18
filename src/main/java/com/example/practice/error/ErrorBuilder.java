package com.example.practice.error;

import com.example.practice.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.ErrorResponse;

@Component
public class ErrorBuilder {
    public ResponseEntity<ApiResponse> buildErrorResponse(Exception exception, HttpStatus httpStatus) {
        ApiResponse errorResponse = new ApiResponse(
                httpStatus.value(),
                "Failed",
                exception.getMessage()
        );
        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
