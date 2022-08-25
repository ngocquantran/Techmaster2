package com.example.userblog.repository;

import com.example.userblog.dto.BlogInfo;
import com.example.userblog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepo extends JpaRepository<Blog, String> {
    @Query(name = "getAllBlogInfo",nativeQuery = true)
    List<BlogInfo> getAllBlogInfo();
}