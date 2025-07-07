package com.sales.todoList.service;

import com.sales.todoList.dtos.TodoRequestDTO;
import com.sales.todoList.dtos.TodoResponseDTO;
import com.sales.todoList.entity.Todo;
import com.sales.todoList.exception.BadRequestException;
import com.sales.todoList.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public TodoResponseDTO createTodo(TodoRequestDTO todoDTO) {
        Todo todo = new Todo();
        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());
        todo.setPriority(todoDTO.getPriority());
        todo.setCompleted(false);

        return convertToDTO(repository.save(todo));
    }

    public List<TodoResponseDTO> listTodo() {
        Sort sort = Sort.by(Sort.Direction.DESC, "priority")
                .and(Sort.by(Sort.Direction.ASC, "id"));

        return repository.findAll(sort).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TodoResponseDTO updateTodo(Long id, TodoRequestDTO todoDTO) {
        Todo todo = repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Todo não encontrado"));

        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());
        todo.setPriority(todoDTO.getPriority());

        return convertToDTO(repository.save(todo));
    }

    public void deleteTodo(Long id) {
        if (!repository.existsById(id)) {
            throw new BadRequestException("Todo não encontrado");
        }
        repository.deleteById(id);
    }

    public TodoResponseDTO markAsCompleted(Long id) {
        Todo todo = repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Todo não encontrado"));

        if (!todo.isCompleted()) {
            todo.setCompleted(true);
            return convertToDTO(repository.save(todo));
        }
        return convertToDTO(todo);
    }

    private TodoResponseDTO convertToDTO(Todo todo) {
        TodoResponseDTO dto = new TodoResponseDTO();
        dto.setId(todo.getId());
        dto.setTitle(todo.getTitle());
        dto.setCompleted(todo.isCompleted());
        dto.setDescription(todo.getDescription());
        dto.setPriority(todo.getPriority());
        return dto;
    }
}