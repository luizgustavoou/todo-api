package com.example.todoapi.services;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.todoapi.models.UserModel;

import jakarta.transaction.Transactional;

public interface UserService {
    @Transactional
    UserDetails findByEmail(String email);

    void save(UserModel userModel);
}
