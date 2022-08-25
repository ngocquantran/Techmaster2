package com.example.practice1.service;

import com.example.practice1.model.CustomUserDetails;
import com.example.practice1.model.User;
import com.example.practice1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.swing.text.html.Option;
import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> o_user=userRepo.findByEmail(username);
       if (o_user.isEmpty()){
           throw new UsernameNotFoundException("User not found");
       }
       return new CustomUserDetails(o_user.get());
    }
}
