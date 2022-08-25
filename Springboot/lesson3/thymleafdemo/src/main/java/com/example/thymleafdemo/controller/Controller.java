package com.example.thymleafdemo.controller;


import com.example.thymleafdemo.model.Book;
import com.example.thymleafdemo.model.Student;
import com.example.thymleafdemo.repository.InMemoryRepository;
import com.example.thymleafdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {

   private static StudentService studentService=new StudentService();
   private static ConcurrentHashMap<String, Student> students= studentService.getAllStudent();

    @GetMapping()
    public String homePage(Model model){
        return "index";
    }

    @GetMapping("/students")
    public String getStudents(Model model){
        model.addAttribute("students",students);
        return "students";
    }

    @GetMapping("/about")
    public String displayAbout(Model model,@RequestParam("name") String a,@RequestParam("age") String b){
        model.addAttribute("name",a);
        model.addAttribute("age",b);
        return "about";
    }

//    @GetMapping(value = "json",produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Book getBook(){
//        return new Book("111","Chí Phèo","Nam Cao");
//    }



}
