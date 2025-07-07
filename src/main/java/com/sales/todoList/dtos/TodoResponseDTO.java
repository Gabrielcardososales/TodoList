package com.sales.todoList.dtos;

import lombok.Data;

@Data
public class TodoResponseDTO {
    private Long id;
    private String title;
    private boolean completed;
    private String description;
    private int priority;
}