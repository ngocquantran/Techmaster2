package com.example.hello;

import com.example.hello.model.hellojpa.Employer;
import com.example.hello.model.hellojpa.Job;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootApplication
@Transactional
public class HelloApplication implements ApplicationRunner {
    @Autowired private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Faker faker=new Faker();
        for (int i=0;i<100;i++){
            Employer employer=Employer.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .website("http://"+faker.internet().domainName().toString())
                    .build();
            entityManager.persist(employer);
        }
        for (int i=0;i<100;i++){
            Job job= Job.builder()
                    .title(faker.job().title())
                    .description(faker.job().keySkills())
                    .build();
            entityManager.persist(job);
        }

        entityManager.flush();
    }
}
