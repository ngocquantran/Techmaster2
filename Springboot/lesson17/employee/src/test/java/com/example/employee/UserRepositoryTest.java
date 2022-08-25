package com.example.employee;


import com.example.employee.model.User;
import com.example.employee.repository.UserRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired
    private UserRepo userRepo;

    @Test
    public void testAddnew() {
        User user = new User();
        user.setEmail("lan@gmail.com");
        user.setFirstName("lan");
        user.setLastName("Trần");
        user.setPassword("345");

        User savedUser = userRepo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        List<User> users= userRepo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
    }

    @Test
    public void updateUser(){
        Integer id=1;
        Optional<User> o_user=userRepo.findById(id);
        User user=o_user.get();
        user.setPassword("789");
        userRepo.save(user);
        User updateUser=userRepo.findById(id).get();
        Assertions.assertThat(updateUser.getPassword()).isEqualTo("789");
    }

    @Test
    public void testDelete(){
        Integer id=2;
        userRepo.deleteById(id);
        Assertions.assertThat(userRepo.findById(id)).isNotPresent();
    }
}
