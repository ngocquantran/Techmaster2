package com.example.todo.repository;

import com.example.todo.model.Todo;
import com.example.todo.request.CreateTodoRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TodoRepo {
    private ConcurrentHashMap<String,Todo> todos;
    public TodoRepo(){
        todos=new ConcurrentHashMap<>();
        String id1= UUID.randomUUID().toString();
        todos.put(id1,new Todo(id1,"Làm bài tập",true));
        String id2= UUID.randomUUID().toString();
        todos.put(id2,new Todo(id2,"Đi xem phim",false));
        String id3= UUID.randomUUID().toString();
        todos.put(id3,new Todo(id3,"Tập gym",false));

    }

    public ConcurrentHashMap<String,Todo> getTodos(){
        return todos;
    }

    public Todo createTodo(CreateTodoRequest request){
//       Có thể Validate title nếu để trống
        String id= UUID.randomUUID().toString();
        Todo newTodo=new Todo(id, request.getTitle(), false);

        todos.put(id,newTodo);
        return newTodo;
    }

    public void deledeTodo(String id){
        todos.remove(id);
    }

}
