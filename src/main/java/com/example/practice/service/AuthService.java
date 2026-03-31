package com.example.practice.service;

import com.example.practice.exception.AlreadyExistException;
import com.example.practice.exception.UnauthorizedException;
import com.example.practice.model.dto.LoginDto;
import com.example.practice.model.dto.UserDto;
import com.example.practice.model.entity.Users;
import com.example.practice.model.mapper.UserMapper;
import com.example.practice.repository.UserRepo;
import com.example.practice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo repository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    public void register(UserDto dto) {
        Optional<Users> userExistWithUsernameOrEmail = repository.findByUsernameOrEmail(dto.getUsername(), dto.getEmail());

        if (userExistWithUsernameOrEmail.isPresent()) {
            throw new AlreadyExistException("User with username or email already exists.");
        }

        Users user = UserMapper.map(dto);
        user.setPassword(encoder.encode(dto.getPassword()));

        repository.save(user);
    }

    public String verify(LoginDto dto) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));

            if (!authentication.isAuthenticated()) {
                throw new UnauthorizedException("Invalid credentials");
            }

            return jwtService.generateToken(dto.getUsername());

        } catch (BadCredentialsException e) {
            throw new UnauthorizedException("Invalid username or password");
        }
    }

}
