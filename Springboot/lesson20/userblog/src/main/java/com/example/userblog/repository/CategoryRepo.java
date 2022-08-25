package com.example.userblog.repository;

import com.example.userblog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    @Query(nativeQuery = true,name = "getPopularCategories")
    List<Category> getPopularCategories(int limit);
}