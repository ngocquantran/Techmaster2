package com.example.login.controller;


import com.example.login.exception.UserException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleExceptionController {

    @ExceptionHandler(UserException.class)
        public String handleUserException(UserException ex, Model model){
        model.addAttribute("error",ex);
        return "error";
    }


}
