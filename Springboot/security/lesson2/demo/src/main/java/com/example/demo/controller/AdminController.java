package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin/blog")
    public String getBlogPage(){
        return "blog";
    }

    @GetMapping("/admin/user")
    public String getUser(){
        return "user";
    }
}
