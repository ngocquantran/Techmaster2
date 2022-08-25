package com.example.login;

import com.example.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartRunner implements ApplicationRunner {

    @Autowired
    UserService userService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        userService.addActiveUser("Trần Ngọc Quân", "quan@gmail.com", "123@quan");
        userService.addUser("Trần Thị Lan", "lan@gmail.com", "123@thilan");

    }
}
