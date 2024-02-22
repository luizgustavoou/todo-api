package com.example.todoapi.dtos;

import com.example.todoapi.enums.Priority;
import com.example.todoapi.enums.Status;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TodoRecordDto(@NotBlank String title, @NotBlank String description, @NotNull Status status,
        @NotNull Priority priority) {

}
