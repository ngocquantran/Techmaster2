package com.example.login;

import com.example.login.hash.Hashing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class TestHash {
    @Autowired
    Hashing hashing;
    @Test
    public void hashPassword(){
        List<String> passwords= List.of("abc","123456@","12345678__hm");
        for (String pw:passwords){
            String hashedPass=hashing.hashPassword(pw);
            assertThat(hashedPass).isNotNull();
        }
    }

    @Test
    public void validatePassword(){
        List<String> passwords= List.of("abc","123456@","12345678__hm");
        for (String pw:passwords){
            String hashedPass=hashing.hashPassword(pw);
            assertThat(hashing.validatePassword(pw,hashedPass)).isTrue();
        }


    }
}
