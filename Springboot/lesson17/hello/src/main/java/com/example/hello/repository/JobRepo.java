package com.example.hello.repository;

import com.example.hello.model.hellojpa.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepo extends JpaRepository<Job, UUID> {
}
