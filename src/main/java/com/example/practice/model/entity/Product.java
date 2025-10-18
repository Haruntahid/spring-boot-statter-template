package com.example.practice.model.entity;

import com.example.practice.utils.commons.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Product extends BaseEntity {
    private String name;
    private String description;
    private Double price;
}
