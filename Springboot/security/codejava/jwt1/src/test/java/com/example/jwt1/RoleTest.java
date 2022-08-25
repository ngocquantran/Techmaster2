package com.example.jwt1;

import com.example.jwt1.model.Role;
import com.example.jwt1.model.User;
import com.example.jwt1.repository.RoleRepo;
import com.example.jwt1.repository.UserRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RoleTest {
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserRepo userRepo;

    @Test
    public void testCreateRole() {
        Role admin = new Role("ROLE_ADMIN");
        Role editor = new Role("ROLE_EDITOR");
        Role customer = new Role("ROLE_CUSTOMER");

        roleRepo.saveAll(List.of(admin, editor, customer));
        long number = roleRepo.count();
        Assertions.assertThat(number).isEqualTo(3);

    }

    @Test
    public void testListRoles() {
        Integer userId = 3;

        User user = userRepo.findById(userId).get();
        user.addRole(new Role(3));

        User updatedUser = userRepo.save(user);
        Assertions.assertThat(updatedUser.getRoles()).hasSize(1);
    }
}
