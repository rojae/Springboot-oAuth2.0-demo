package com.auth.ibct.ibct.controllers;

import lombok.extern.slf4j.Slf4j;

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
@RequestMapping("/api/signin")
public class LoginController {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public LoginController(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    User signin(@RequestParam String email, @RequestParam String password) {
        User u = new User(null, email, passwordEncoder.encode(password), User.Role.USER);
        return repository.save(u);
    }

    @PostMapping("/validateEmail")
    Boolean emailExists(@RequestParam String email) {
        return repository.existsByEmail(email);
    }

}