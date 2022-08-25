package com.example.userblog.service;

import com.example.userblog.dto.BlogInfo;
import com.example.userblog.repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogService {
    @Autowired private BlogRepo blogRepo;

    public List<BlogInfo> getAllBlogInfo(){
        return blogRepo.getAllBlogInfo();
    }

    public List<BlogInfo> getBlogPopular(int limit){
        return blogRepo.getAllBlogInfo()
                .stream()
                .sorted((a,b)->b.getCountComment()-a.getCountComment())
                .limit(limit)
                .collect(Collectors.toList());
    }

    public BlogInfo getBlogInfoById(String id){
        Optional<BlogInfo> blogInfo= blogRepo.getAllBlogInfo()
                .stream()
                .filter(blog -> blog.getId().equals(id))
                .findFirst();
        return blogInfo.orElse(null);

    }
}
