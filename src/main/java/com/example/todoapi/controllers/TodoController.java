package com.example.todoapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapi.dtos.TodoRecordDto;
import com.example.todoapi.models.TodoModel;
import com.example.todoapi.services.TodoService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/todo")
@RestController
public class TodoController {
    @Autowired
    TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoModel> save(@RequestBody TodoRecordDto todoRecordDto) {
        var todoModel = new TodoModel();

        BeanUtils.copyProperties(todoRecordDto, todoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.save(todoModel));
    }

    @GetMapping
    public ResponseEntity<List<TodoModel>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOneById(@PathVariable(value = "id") UUID id) {
        Optional<TodoModel> todoModel = todoService.findOneById(id);

        if (todoModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo not found.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(todoModel.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        Optional<TodoModel> todoModel = todoService.findOneById(id);

        if (todoModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo not found.");
        }

        todoService.delete(todoModel.get());

        return ResponseEntity.status(HttpStatus.OK).body("Todo deleted successfully.");

    }

}
