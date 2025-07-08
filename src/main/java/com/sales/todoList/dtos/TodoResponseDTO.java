package com.sales.todoList.dtos;

import lombok.Data;

// TodoResponseDTO.java
import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class TodoResponseDTO {

    @Schema(description = "ID da tarefa", example = "1")
    private Long id;

    @Schema(description = "Título da tarefa", example = "Estudar Swagger")
    private String title;

    @Schema(description = "Status de conclusão", example = "false")
    private boolean completed;

    @Schema(description = "Descrição da tarefa")
    private String description;

    @Schema(description = "Prioridade da tarefa", example = "3")
    private int priority;
}
