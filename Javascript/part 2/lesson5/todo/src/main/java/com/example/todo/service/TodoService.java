package com.example.todo.service;


import com.example.todo.exception.NotFoundException;
import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepo;
import com.example.todo.request.CreateTodoRequest;
import com.example.todo.request.UpdateTodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;


    public List<Todo> getTodos(ConcurrentHashMap<String, Todo> todos, String status) {
        return switch (status) {
            case "true" -> todos.values().stream().filter(Todo::isStatus).collect(Collectors.toList());
            case "false" -> todos.values().stream().filter(todo -> !todo.isStatus()).collect(Collectors.toList());
            default -> todos.values().stream().toList();
        };
    }

    public Todo getTodoById(String id) {
        Optional<Todo> todoOptional = findById(todoRepo.getTodos(), id);
        if (todoOptional.isPresent()) {
            return todoOptional.get();
        }
        throw new NotFoundException("Không tìm thấy công việc có id=" + id);
    }


    //    Helper method: Tìm kiếm 1 todo theo id
    public Optional<Todo> findById(ConcurrentHashMap<String, Todo> todos, String id) {
        return Optional.ofNullable(todos.get(id) );
//        return todos.values().stream().filter(todo -> todo.getId().equals(id)).findFirst();
    }


    public Todo createTodo(CreateTodoRequest request) {
        return todoRepo.createTodo(request);
    }

    public Todo updateTodo(String id, UpdateTodoRequest request) {
//        if (!todoRepo.getTodos().containsKey(id)){
//            throw new NotFoundException("Không tìm thấy công việc có id=" +id);
//        }
//        Todo todo=todoRepo.getTodos().get(id);

        Todo todo = getTodoById(id);
        todo.setTitle(request.getTitle());
//        todo.setStatus(request.isStatus());
        return todo;

    }

    public void deleteTodo(String id){
        getTodoById(id);
        todoRepo.deledeTodo(id);
    }


}
