package com.example.hello;

import javax.persistence.EntityManager;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
public class TestVocab {

    @Autowired private EntityManager en;

    @Test
    public void testVocabLevel(){

    }
}
