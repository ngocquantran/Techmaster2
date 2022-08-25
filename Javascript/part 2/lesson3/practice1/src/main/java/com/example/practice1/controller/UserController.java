package com.example.practice1.controller;


import com.example.practice1.Request.UserLoginRequest;
import com.example.practice1.Service;
import com.example.practice1.model.User;
import com.example.practice1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired private Service service;


    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public User login(@RequestBody UserLoginRequest request){
        return service.getUser(userRepo.getAllUsers(), userRepo.getIdByUserName(), request.getUsername(), request.getPassword());
    }
}
