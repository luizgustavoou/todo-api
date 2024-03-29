package com.example.todoapi.models;

import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;

import com.example.todoapi.enums.TodoPriority;
import com.example.todoapi.enums.TodoStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GenerationType;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "todoId")
public class TodoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "todo_id")
    private UUID todoId;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TodoPriority priority;

    @Enumerated(EnumType.STRING)
    private TodoStatus status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    // private Comments comments;

}
