package com.sales.todoList.controller;

import com.sales.todoList.dtos.TodoRequestDTO;
import com.sales.todoList.dtos.TodoResponseDTO;
import com.sales.todoList.service.TodoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TodoResponseDTO>> listTodo() {
        return ResponseEntity.ok(service.listTodo());
    }

    @PostMapping
    public ResponseEntity<TodoResponseDTO> createTodo(@Valid @RequestBody TodoRequestDTO todoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createTodo(todoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDTO> updateTodo(
            @PathVariable @Min(1) Long id,
            @Valid @RequestBody TodoRequestDTO todoDTO) {
        return ResponseEntity.ok(service.updateTodo(id, todoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable @Min(1) Long id) {
        service.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<TodoResponseDTO> markAsCompleted(@PathVariable @Min(1) Long id) {
        return ResponseEntity.ok(service.markAsCompleted(id));
    }
}