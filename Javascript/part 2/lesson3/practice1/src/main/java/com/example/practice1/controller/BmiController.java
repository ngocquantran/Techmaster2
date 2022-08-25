package com.example.practice1.controller;


import com.example.practice1.Service;
import com.example.practice1.model.Bmi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class BmiController {
    @Autowired private Service service;

    @GetMapping("/bmi")
    public double calculateBmi(@RequestParam double height, @RequestParam double weight){
        return service.bmiCalculate(height, weight);
    }

    @PostMapping (value = "/bmi",produces = MediaType.APPLICATION_JSON_VALUE)
    public double calculateBmi2(@RequestBody Bmi bmi){
        return service.bmiCalculate(bmi.getHeight(), bmi.getWeight());
    }





}
