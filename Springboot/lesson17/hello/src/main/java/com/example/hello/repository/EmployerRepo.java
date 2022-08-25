package com.example.hello.repository;

import com.example.hello.model.hellojpa.Employer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployerRepo extends JpaRepository<Employer,Long> {
}
