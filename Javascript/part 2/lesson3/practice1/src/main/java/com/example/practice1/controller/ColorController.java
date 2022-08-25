package com.example.practice1.controller;


import com.example.practice1.Service;
import com.example.practice1.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorController {

    @Autowired
    private Service service;

    @GetMapping("/random-color")
    public String getRandomColor(@RequestParam int type) {
        String result="";
        switch (type) {
            case 1:
                result = service.getRandomColorName();
                break;
            case 2:
                result = service.getRandomColorHex();
                break;
            case 3:
                result = service.getRandomColorRGB();
                break;
            default:
                throw new BadRequestException("type = "+type + " không hợp lệ");


        };
        return result;
    }
}
