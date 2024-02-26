package com.example.todoapi.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapi.dtos.TodoRecordDto;
import com.example.todoapi.models.UserModel;
import com.example.todoapi.services.UserService;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserModel> save(@RequestBody TodoRecordDto todoRecordDto) {
        var userModel = new UserModel();

        BeanUtils.copyProperties(todoRecordDto, userModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOneById(@PathVariable(value = "id") UUID id) {
        Optional<UserModel> userModel = userService.findOneById(id);

        if (userModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo not found.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(userModel.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        Optional<UserModel> userModel = userService.findOneById(id);

        if (userModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo not found.");
        }

        userService.delete(userModel.get());

        return ResponseEntity.status(HttpStatus.OK).body("Todo deleted successfully.");

    }
}
