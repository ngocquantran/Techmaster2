package com.example.login;

import com.example.login.model.State;
import com.example.login.model.User;
import com.example.login.repository.UserRepo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TestUserRepo {
    @Test
    public void addUser(){
        UserRepo userRepo=new UserRepo();
        User user=userRepo.addUser("Quân","quan@gmail.com","hhhhh", State.PENDING);
        assertThat(user).isNotNull();
        System.out.println("id= "+user.getId());
        assertThat(user.getId()).isNotNull();
        assertThat(user.getState()).isEqualTo(State.PENDING);
    }

    @Test
    public void isEmailExist() {
        UserRepo userRepo = new UserRepo();
        userRepo.addUser("Quân", "quan@gmail.com", "hhhhh", State.PENDING);
        userRepo.addUser("Bắc", "bac@gmail.com", "hhhhh", State.PENDING);
        userRepo.addUser("Đức", "duc@gmail.com", "hhhhh", State.PENDING);

        assertThat(userRepo.isEmailExist("quan@gmail.com")).isTrue();
        assertThat(userRepo.isEmailExist("lan@gmail.com")).isFalse();
        assertThat(userRepo.isEmailExist("Quan@gmail.com")).isTrue();
    }

    @Test
    public void findUser() {
        UserRepo userRepo = new UserRepo();
        userRepo.addUser("Quân", "quan@gmail.com", "hhhhh", State.PENDING);
        userRepo.addUser("Bắc", "bac@gmail.com", "hhhhh", State.PENDING);
        userRepo.addUser("Đức", "duc@gmail.com", "hhhhh", State.PENDING);

        assertThat(userRepo.findByEmail("qUAn@gmail.com")).isPresent();
        assertThat(userRepo.findByEmail("an@gmail.com")).isEmpty();
    }


}
