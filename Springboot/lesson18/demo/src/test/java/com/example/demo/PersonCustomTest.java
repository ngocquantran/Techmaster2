package com.example.demo;


import com.example.demo.controller.PrintForTest;
import com.example.demo.customrepo.CityJobCount;
import com.example.demo.customrepo.JobCount;

import com.example.demo.customrepo.JobSalary;
import com.example.demo.customrepo.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@DataJpaTest
public class PersonCustomTest {
    @Autowired private PersonRepository personRepo;
    @Autowired private EntityManager em;

    @Test
    void testCountJob(){
        List<JobCount> jobs=personRepo.countByJob();
        jobs.stream().forEach(System.out::println);
        Assertions.assertThat(jobs.stream().map(JobCount::getCount).mapToLong(Long::longValue).sum()).isEqualTo(1000);
    }

    @Test
    void findTopJob(){
        List<JobCount> jobs=personRepo.findTopJob(PageRequest.of(0,5));
        Assertions.assertThat(jobs).hasSize(5);
        jobs.stream().forEach(System.out::println);
        System.out.println("hehehe");
    }

    @Test
    void findJobByCity(){
        List<CityJobCount> jobs=personRepo.countJobsInCity();
        jobs.stream().forEach(cityJobCount -> PrintForTest.print(cityJobCount.toString()));
    }

    @Test
    void jobAvg(){
        List<JobSalary> jobs=personRepo.jobAverageSalary();
        jobs.stream().forEach(System.out::println);
    }



}
