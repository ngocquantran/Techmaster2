package com.example.practice1.service;

import com.example.practice1.model.MyUserDetails;
import com.example.practice1.model.User;
import com.example.practice1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> o_user=userRepo.findByUsername(username);
        if (o_user.isEmpty()){
            throw new UsernameNotFoundException("Username not found");
        }
        return new MyUserDetails(o_user.get());
    }
}
