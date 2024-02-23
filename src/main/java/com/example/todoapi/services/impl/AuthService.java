package com.example.todoapi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.todoapi.dtos.LoginRecordDto;
import com.example.todoapi.dtos.RegisterRecordDto;
import com.example.todoapi.infra.security.TokenService;
import com.example.todoapi.models.UserModel;
import com.example.todoapi.repositories.UserRepository;
import com.example.todoapi.services.UserService;

import org.springframework.context.ApplicationContext;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    // @Autowired
    // AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationContext context;

    @Autowired
    TokenService tokenService;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username);
    }

    String login(LoginRecordDto loginRecordDto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginRecordDto.email(),
                loginRecordDto.password());
        var auth = context.getBean(AuthenticationManager.class).authenticate(usernamePassword);

        var token = tokenService.generateToken((UserModel) auth.getPrincipal());

        return token;
    }

    void register(RegisterRecordDto registerRecordDto) {
        if (userService.findByEmail(registerRecordDto.email()) != null) {
            // fazer algo...
            throw new RuntimeException("User not found.");
        }

        String encryptedPassword = passwordEncoder.encode(registerRecordDto.password());

        UserModel newUser = new UserModel(registerRecordDto.email(), encryptedPassword, registerRecordDto.role());

        this.userService.save(newUser);
    }
}