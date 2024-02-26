package com.example.todoapi.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.todoapi.models.UserModel;

import jakarta.transaction.Transactional;

public interface UserService {
    @Transactional
    UserDetails findByEmail(String email);

    public List<UserModel> findAll();

    public Optional<UserModel> findOneById(UUID id);

    @Transactional
    public void delete(UserModel userModel);

    UserModel save(UserModel userModel);
}
