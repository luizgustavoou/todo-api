package com.example.todoapi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todoapi.models.TodoModel;

@Repository
public interface TodoRepository extends JpaRepository<TodoModel, UUID> {

}
