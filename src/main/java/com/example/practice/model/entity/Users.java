package com.example.practice.model.entity;

import com.example.practice.utils.commons.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class Users extends BaseEntity {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private String phone;
}
