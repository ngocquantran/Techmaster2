package com.example.login.controller;


import com.example.login.dto.UserDto;
import com.example.login.exception.UserException;
import com.example.login.model.User;
import com.example.login.request.LoginRequest;
import com.example.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequest("", ""));
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@Valid @ModelAttribute("loginRequest") LoginRequest request, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "login";
        }
        User user;
        try {
            user = userService.login(request.email(), request.password());
            session.setAttribute("user", new UserDto(user.getId(), user.getFullName(), user.getEmail()));
            return "redirect:/";
        } catch (UserException e) {
            switch (e.getMessage()) {
                case "User is not found":
                    result.addError(new FieldError("loginRequest", "email", "User is not found"));
                    break;
                case "User is not activated":
                    result.addError(new FieldError("loginRequest", "email", "User is not activated"));
                    break;
                case "Password is incorrect":
                    result.addError(new FieldError("loginRequest", "password", "Password is incorrect"));
                    break;
            }

        }
        return "login";


    }


    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @GetMapping("/logout")
    public String showError() {
        throw new UserException("Xin lỗi");
    }


}
