package com.sales.todoList.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

// TodoRequestDTO.java
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TodoRequestDTO {

    @Schema(description = "Título da tarefa", example = "Estudar Swagger")
    @NotBlank(message = "O título não pode estar vazio")
    private String title;

    @Schema(description = "Descrição opcional da tarefa", example = "Revisar anotações e exemplos")
    @Size(max = 500, message = "A descrição não pode ultrapassar 500 caracteres")
    private String description;

    @Schema(description = "Prioridade da tarefa de 1 (baixa) a 5 (alta)", example = "3")
    @Min(value = 1, message = "A prioridade deve ser no mínimo 1")
    @Max(value = 5, message = "A prioridade deve ser no máximo 5")
    private int priority;
}
