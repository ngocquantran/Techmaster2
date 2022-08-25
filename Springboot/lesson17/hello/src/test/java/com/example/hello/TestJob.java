package com.example.hello;


import com.example.hello.model.hellojpa.Job;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class TestJob {
    @Autowired private EntityManager en;

    @Test
    public void addJob(){
        Job job= Job.builder()
                .title("Java developer")
                .description("làm này làm kia")
                .build();
        en.persist(job);
        System.out.println(job.getId());
        assertThat(job).isNotNull();
    }
}
