package com.example.todo.controller;


import com.example.todo.repository.TodoRepo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoViewController {
    @Autowired private TodoRepo todoRepo;
    @Autowired private TodoService todoService;

    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("todos",todoService.getTodos(todoRepo.getTodos(), ""));
        return "index";
    }



}
