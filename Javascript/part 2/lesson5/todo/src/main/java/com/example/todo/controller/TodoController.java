package com.example.todo.controller;


import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepo;
import com.example.todo.request.CreateTodoRequest;
import com.example.todo.request.UpdateTodoRequest;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TodoController {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private TodoService todoService;

    //    Lấy danh sách
    @GetMapping("/todos")
    public List<Todo> getTodos(@RequestParam(required = false, defaultValue = "") String status) {
        return todoService.getTodos(todoRepo.getTodos(), status);
    }

    //    Lấy task theo id
    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable String id) {
        return todoService.getTodoById(id);

    }

    //    Tạo task
    @PostMapping("/todos")
    public ResponseEntity<Todo> createTodo(@RequestBody CreateTodoRequest request) {
        Todo todo = todoService.createTodo(request);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    //    Cập nhật công việc
    @PutMapping("/todos/{id}")
    public Todo updateTodo(@RequestBody UpdateTodoRequest request, @PathVariable String id) {
        return todoService.updateTodo(id, request);

    }

    @DeleteMapping("/todos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable String id) {
        todoService.deleteTodo(id);

    }

}
