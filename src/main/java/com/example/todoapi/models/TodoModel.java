package com.example.todoapi.models;

import java.io.Serializable;
import java.util.UUID;

import com.example.todoapi.enums.Priority;
import com.example.todoapi.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Entity
public class TodoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;

    private String description;

    private Priority priority;

    private Status status;

    // private User user;

    // private Comments comments;

}
