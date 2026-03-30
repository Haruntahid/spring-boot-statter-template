package com.example.practice.model.entity;

import com.example.practice.utils.commons.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user")
public class Users extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false,updatable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Email(message = "Provide a valid Email address")
    @Column(nullable = false,unique = true,updatable = false)
    private String email;

    @Column(updatable = false)
    private LocalDateTime createdAt;


    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
