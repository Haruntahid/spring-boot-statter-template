package com.example.practice.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDto {
    @NotNull(message = "Name cannot be empty.")
    @Size(min = 3, max = 50, message = "Name must be between 3–50 characters")
    private String name;

    private String description;

    @NotNull(message = "Price cannot be empty")
    @Positive(message = "Price must be greater than 0")
    private Double price;
}
