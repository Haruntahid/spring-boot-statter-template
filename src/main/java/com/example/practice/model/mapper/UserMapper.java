package com.example.practice.model.mapper;


import com.example.practice.model.dto.UserDto;
import com.example.practice.model.entity.Users;



public interface UserMapper {

    public static Users map(UserDto dto) {
        Users user = new Users();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        return user;
    }

    public static UserDto map(Users user) {
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        return dto;
    }
}
