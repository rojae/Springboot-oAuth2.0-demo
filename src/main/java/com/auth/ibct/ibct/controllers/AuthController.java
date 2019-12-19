package com.auth.ibct.ibct.controllers;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

import com.auth.ibct.ibct.entities.User;
import com.auth.ibct.ibct.repositories.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("v1/api/auth")
public class AuthController {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup")
    User signin(@RequestParam String email, @RequestParam String password) {
        
        User u = new User(UUID.randomUUID().toString(), email, passwordEncoder.encode(password), User.Role.USER);

        u.setCreatedBy(u.getId().toString());
        u.setCreatedAt(java.time.Instant.now());

        return repository.save(u);
    }

    @PostMapping("/validateEmail")
    Boolean emailExists(@RequestParam String email) {
        return repository.existsByEmail(email);
    }

}