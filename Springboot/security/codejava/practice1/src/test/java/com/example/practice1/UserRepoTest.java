package com.example.practice1;


import com.example.practice1.model.User;
import com.example.practice1.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepoTest {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user=User.builder()
                .email("nam@gmail.com")
                .password("123456")
                .firstName("Văn")
                .lastName("Nam")
               .build();
        User savedUser=userRepo.save(user);
        User existUser=entityManager.find(User.class,savedUser.getId());

        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testFindUserByEmail(){
        String email="quan@gmail.com";
        Optional<User> o_user=userRepo.findByEmail(email);
        assertThat(o_user).isPresent();
    }


}
