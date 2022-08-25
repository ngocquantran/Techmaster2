package com.example.userblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @GetMapping("/admin/blog")
    public String getBlogPage(){
        return "admin";
    }
}
