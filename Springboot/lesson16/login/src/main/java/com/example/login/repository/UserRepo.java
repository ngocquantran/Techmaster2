package com.example.login.repository;

import com.example.login.model.State;
import com.example.login.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@AllArgsConstructor

public class UserRepo {
    private ConcurrentHashMap<String, User> users;
    public UserRepo(){
        users=new ConcurrentHashMap<>();

    }


    public User addPendingUser(String fullName, String email, String hashedPassword){
        return addUser(fullName,email,hashedPassword,State.PENDING);
    }


    public User addUser(String fullName, String email, String hashedPassword, State state){
        String id= UUID.randomUUID().toString();
        User user=User.builder()
                .id(id)
                .fullName(fullName)
                .email(email)
                .hashedPassword(hashedPassword)
                .state(state)
                .build();

        users.put(id,user);
        return user;
    }

    public boolean isEmailExist(String email){
        return users.values().stream().anyMatch(user -> user.getEmail().equalsIgnoreCase(email));
    }

    public Optional<User> findByEmail(String email){
        return users.values().stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).findFirst();
    }
}
