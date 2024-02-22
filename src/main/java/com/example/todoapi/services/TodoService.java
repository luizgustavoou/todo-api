package com.example.todoapi.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.todoapi.models.TodoModel;

import jakarta.transaction.Transactional;

public interface TodoService {
    @Transactional
    public TodoModel save(TodoModel todoModel);

    public List<TodoModel> findAll();

    public Optional<TodoModel> findOneById(UUID id);

    @Transactional
    public void delete(TodoModel todoModel);

}
