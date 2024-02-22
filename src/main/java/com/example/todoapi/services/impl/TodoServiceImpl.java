package com.example.todoapi.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapi.dtos.TodoRecordDto;
import com.example.todoapi.models.TodoModel;
import com.example.todoapi.repositories.TodoRepository;
import com.example.todoapi.services.TodoService;

import jakarta.transaction.Transactional;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepository todoRepository;

    @Transactional
    public TodoModel save(TodoModel todoModel) {
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
