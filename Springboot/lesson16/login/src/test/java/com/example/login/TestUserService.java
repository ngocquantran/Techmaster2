package com.example.login;

import com.example.login.exception.UserException;
import com.example.login.model.User;
import com.example.login.service.UserService;
import com.example.login.service.UserServiceInMemory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class TestUserService {
    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        User user = userService.addUser("Trần Ngọc Quân", "quan@gmail.com", "123@quan");
        assertThat(user).isNotNull();
    }

    @Test
    public void login_when_account_is_pending() {
        User user = userService.addUser("Trần Ngọc Quân", "quan@gmail.com", "123@quan");
        assertThatThrownBy(() -> {
            userService.login("quan@gmail.com","123@quan");
        }).isInstanceOf(UserException.class).hasMessageContaining("User is not activated");
    }

    @Test
    public void login_when_account_is_not_found(){
        assertThatThrownBy(()->{
            userService.login("quan@gmail.co","123@quan");
        }).isInstanceOf(UserException.class).hasMessageContaining("User is not found");
    }

    @Test
    public void login_when_password_is_incorrect(){
        User user=userService.addActiveUser("Trần Ngọc Quân", "quan@gmail.com", "123@quan");
        assertThatThrownBy(()-> {
            userService.login("quan@gmail.com", "123@qu");
        }).isInstanceOf(UserException.class).hasMessageContaining("Password is incorrect");
    }

    @Test
    public void login_success(){
        userService.addActiveUser("Trần Ngọc Quân", "quan@gmail.com", "123@quan");
        User user=userService.login("quan@gmail.com", "123@quan");

        assertThat(user).isNotNull();
    }



}
