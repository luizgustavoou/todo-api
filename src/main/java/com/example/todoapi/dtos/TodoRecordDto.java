package com.example.todoapi.dtos;

import java.util.UUID;

import com.example.todoapi.enums.TodoPriority;
import com.example.todoapi.enums.TodoStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TodoRecordDto(@NotBlank String title, @NotBlank String description, @NotNull TodoStatus status,
        @NotNull TodoPriority priority, @NotBlank @NotNull UUID user_id) {

}
