package com.example.todoapi.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapi.models.TodoModel;
import com.example.todoapi.models.UserModel;
import com.example.todoapi.repositories.TodoRepository;
import com.example.todoapi.services.TodoService;
import com.example.todoapi.services.UserService;

import jakarta.transaction.Transactional;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    UserService userService;

    @Autowired
    TodoRepository todoRepository;

    @Transactional
    public TodoModel save(TodoModel todoModel, UUID userId) {

        Optional<UserModel> user = userService.findOneById(userId);

        if (user.isEmpty()) {
            throw new RuntimeException("User not found.");
        }

        todoModel.setUser(user.get());

        return todoRepository.save(todoModel);
    }

    public List<TodoModel> findAll() {
        return todoRepository.findAll();
    }

    public Optional<TodoModel> findOneById(UUID id) {
        return todoRepository.findById(id);
    }

    @Transactional
    public void delete(TodoModel todoModel) {
        todoRepository.delete(todoModel);
    }

}
