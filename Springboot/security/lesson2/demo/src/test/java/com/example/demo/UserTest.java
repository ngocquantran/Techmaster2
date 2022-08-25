package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    void save_user(){
        User user1=User.builder()
                .name("Quân")
                .email("quan@gmail.com")
                .password(passwordEncoder.encode("123456"))
                .role(List.of("USER","EDITOR","ADMIN"))
                .build();
        User user2=User.builder()
                .name("Nam")
                .email("nam@gmail.com")
                .password(passwordEncoder.encode("123456"))
                .role(List.of("USER","EDITOR"))
                .build();
        User user3=User.builder()
                .name("Lan")
                .email("lan@gmail.com")
                .password(passwordEncoder.encode("123456"))
                .role(List.of("USER"))
                .build();

        userRepo.saveAll(List.of(user1,user2,user3));
    }
}
