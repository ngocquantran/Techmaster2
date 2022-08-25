package com.example.practice1.controller;


import com.example.practice1.model.Product;
import com.example.practice1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
    @Autowired private ProductService service;

    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Product> list=service.listAll();
        model.addAttribute("listProducts",list);
        return "index";
    }

    @GetMapping("/new")
    public String showNewProductForm(Model model){
        model.addAttribute("product",new Product());
        return "new_product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product){
        service.save(product);
        return "redirect:/";
    }

    @RequestMapping("edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id){
        ModelAndView mav=new ModelAndView("edit_product");
        Product product=service.get(id);
        mav.addObject("product",product);
        return mav;
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        service.delete(id);
        return "redirect:/";
    }


}
