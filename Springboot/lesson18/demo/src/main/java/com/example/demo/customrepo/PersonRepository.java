package com.example.demo.customrepo;

import com.example.demo.model.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, PersonRepoCustom {
    @Query("select new com.example.demo.customrepo.JobCount(p.job,count (*)) "+
    "from person as p group by p.job order by 2 desc ")
    List<JobCount> countByJob();

    @Query("select new com.example.demo.customrepo.JobCount(p.job,count (*)) "+
            "from person as p group by p.job order by 2 desc ")
    List<JobCount> findTopJob(Pageable pageable);


    @Query("select new com.example.demo.customrepo.CityJobCount(p.city,p.job,COUNT (*)) "+
    "from person as p group by p.city,p.job")
    List<CityJobCount> countJobsInCity();

    @Query("select new com.example.demo.customrepo.JobSalary(p.job,AVG (p.salary)) "+
    "from person as p group by p.job order by 2 desc ")
    List<JobSalary> jobAverageSalary();






}