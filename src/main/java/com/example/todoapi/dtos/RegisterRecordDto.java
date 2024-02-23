package com.example.todoapi.dtos;

import com.example.todoapi.enums.UserRole;

public record RegisterRecordDto(String email, String password, UserRole role) {
}