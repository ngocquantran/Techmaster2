package com.example.hello.controller;


import com.example.hello.model.hellojpa.Employer;
import com.example.hello.repository.EmployerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {
    @Autowired
    private EmployerRepo employerRepo;

    @GetMapping
    public List<Employer> getAll() {
        return employerRepo.findAll();
    }

    @GetMapping("id/{id}")
    public Optional<Employer> getById(@PathVariable Long id) {
        return employerRepo.findById(id);
    }

}
