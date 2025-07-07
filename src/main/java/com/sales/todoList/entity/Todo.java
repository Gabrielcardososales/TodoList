package com.sales.todoList.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título não pode estar vazio")
    private String title;

    private boolean completed;

    @Size(max = 500, message = "A descrição não pode ultrapassar 500 caracteres")
    private String description;

    @Min(value = 1, message = "A prioridade deve ser no mínimo 1")
    @Max(value = 5, message = "A prioridade deve ser no máximo 5")
    private int priority;
}
