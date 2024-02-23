package com.example.todoapi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.todoapi.models.UserModel;
import com.example.todoapi.repositories.UserRepository;
import com.example.todoapi.services.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public void save(UserModel userModel) {
        userRepository.save(userModel);
    }

}
