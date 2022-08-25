package com.example.hello.controller;


import com.example.hello.model.hellojpa.Job;
import com.example.hello.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/job")
public class JobController {

    @Autowired private JobRepo jobRepo;

    @GetMapping
    public List<Job> getAll(){
        return jobRepo.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<Job> getJob(@PathVariable UUID id){

        return jobRepo.findById(id);
    }
}
