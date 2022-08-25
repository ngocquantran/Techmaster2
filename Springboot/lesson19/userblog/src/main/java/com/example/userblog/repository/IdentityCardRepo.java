package com.example.userblog.repository;

import com.example.userblog.model.IdentityCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityCardRepo extends JpaRepository<IdentityCard, Integer> {
}