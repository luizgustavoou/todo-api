package com.example.todoapi.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapi.dtos.LoginRecordDto;
import com.example.todoapi.dtos.LoginResponseRecordDto;
import com.example.todoapi.dtos.RegisterRecordDto;
import com.example.todoapi.infra.security.TokenService;
import com.example.todoapi.models.UserModel;
import com.example.todoapi.services.UserService;
import com.example.todoapi.services.impl.AuthServiceImpl;

import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    AuthServiceImpl authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginRecordDto loginRecordDto) {
        // var usernamePassword = new
        // UsernamePasswordAuthenticationToken(loginRecordDto.email(),
        // loginRecordDto.password());
        // var auth = this.authenticationManager.authenticate(usernamePassword);

        // var token = tokenService.generateToken((UserModel) auth.getPrincipal());

        var token = authService.login(loginRecordDto);

        return ResponseEntity.ok(new LoginResponseRecordDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterRecordDto registerRecordDto) {
        if (this.userService.findByEmail(registerRecordDto.email()) != null)
            return ResponseEntity.badRequest().build();

        String encryptedPassword = passwordEncoder.encode(registerRecordDto.password());
        UserModel newUser = new UserModel(registerRecordDto.email(),
                encryptedPassword, registerRecordDto.role());

        this.userService.save(newUser);

        // authService.register(registerRecordDto);

        return ResponseEntity.ok().build();
    }
}