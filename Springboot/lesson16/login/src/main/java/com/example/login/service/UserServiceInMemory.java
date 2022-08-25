package com.example.login.service;

import com.example.login.exception.UserException;
import com.example.login.hash.Hashing;
import com.example.login.model.State;
import com.example.login.model.User;
import com.example.login.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceInMemory implements UserService {
    private UserRepo userRepo;
    private Hashing hashing;


    @Override
    public User login(String email, String password) {
        Optional<User> o_user = userRepo.findByEmail(email);
        if (!o_user.isPresent()) {
            throw new UserException("User is not found");
        }

        User user = o_user.get();
        if (user.getState()!=State.ACTIVE){
            throw new UserException("User is not activated");
        }
        if (hashing.validatePassword(password, user.getHashedPassword())){
            return user;
        }else {
            throw new UserException("Password is incorrect");
        }

    }

    @Override
    public Boolean logout(String email) {
        return null;
    }

    @Override
    public User addUser(String fullName, String email, String password) {
        return userRepo.addPendingUser(fullName, email,hashing.hashPassword(password));
    }

    @Override
    public User addActiveUser(String fullName, String email, String password) {
        return userRepo.addUser(fullName, email, hashing.hashPassword(password), State.ACTIVE);
    }

    @Override
    public Boolean activateUser(String activation_code) {
        return null;
    }

    @Override
    public Boolean updatePassword(String email, String password) {
        return null;
    }

    @Override
    public Boolean updateEmail(String email, String newEmail) {
        return null;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public User findById(String id) {
        return null;
    }
}
