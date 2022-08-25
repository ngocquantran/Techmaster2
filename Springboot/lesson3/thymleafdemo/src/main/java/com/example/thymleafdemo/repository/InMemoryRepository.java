package com.example.thymleafdemo.repository;

import com.example.thymleafdemo.model.Student;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryRepository {
    private ConcurrentHashMap<String, Student> students;


}
