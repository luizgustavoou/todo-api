package com.example.todoapi.services;

import com.example.todoapi.dtos.LoginRecordDto;
import com.example.todoapi.dtos.RegisterRecordDto;

public interface AuthService {
    String login(LoginRecordDto loginRecordDto);

    void register(RegisterRecordDto registerRecordDto);
}
