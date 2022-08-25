package com.example.userblog.controller;

import com.example.userblog.repository.CategoryRepo;
import com.example.userblog.service.BlogService;
import net.bytebuddy.utility.nullability.AlwaysNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @Autowired private BlogService blogService;
    @Autowired private CategoryRepo categoryRepo;


    @GetMapping("/")
    public String getHomepage(Model model){
        model.addAttribute("blogs",blogService.getAllBlogInfo());
        model.addAttribute("popularBlogs",blogService.getBlogPopular(3));
        model.addAttribute("categories",categoryRepo.getPopularCategories(5));
        return "web/index";
    }

    @GetMapping("blogs/{id}/{slugs}")
    public String getDetailPage(@PathVariable String id,Model model){
        model.addAttribute("blog",blogService.getBlogInfoById(id));

        return "web/detail";
    }

    @GetMapping("/about")
    public String getAboutPage(){
        return "web/about";
    }

    @GetMapping("/contact")
    public String getContactPage(){
        return "web/contact";
    }

}
