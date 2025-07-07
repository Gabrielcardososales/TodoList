package com.sales.todoList.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TodoRequestDTO {
    @NotBlank(message = "O título não pode estar vazio")
    private String title;

    @Size(max = 500, message = "A descrição não pode ultrapassar 500 caracteres")
    private String description;

    @Min(value = 1, message = "A prioridade deve ser no mínimo 1")
    @Max(value = 5, message = "A prioridade deve ser no máximo 5")
    private int priority;
}