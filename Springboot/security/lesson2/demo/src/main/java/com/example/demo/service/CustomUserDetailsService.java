package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> o_user=userRepo.findByEmail(username);
        if (o_user.isEmpty()){
            throw new UsernameNotFoundException("Email not found");
        }
        return new CustomUserDetails(o_user.get());
    }
}
