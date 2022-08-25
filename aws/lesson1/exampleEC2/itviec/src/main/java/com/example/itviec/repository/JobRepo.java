package com.example.itviec.repository;

import com.example.itviec.model.*;
import com.example.itviec.request.EmployerRequest;
import com.example.itviec.request.JobRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class JobRepo {

    private final ConcurrentHashMap<String, Job> jobs;

    public JobRepo() {
        EmployerRepo employerRepo = new EmployerRepo();
        jobs = new ConcurrentHashMap<>();
        List<Employer> employers = employerRepo.getEmployers().values().stream().toList();
        String id = UUID.randomUUID().toString();
        jobs.put(id, new Job(id, "lập trình", employers.get(0).getId(), employers.get(0).getCompanyName(), List.of(Skill.java), List.of(Location.hanoi), 500, 1000, "hahaha"));
        String id2 = UUID.randomUUID().toString();
        jobs.put(id2, new Job(id2, "lập trình SpringBoot", employers.get(1).getId(), employers.get(1).getCompanyName(), List.of(Skill.spring), List.of(Location.hanoi, Location.danang), 100, 1000, "làm này làm kia"));
        String id3 = UUID.randomUUID().toString();
        jobs.put(id3, new Job(id3, "Middle Python", employers.get(2).getId(), employers.get(2).getCompanyName(), List.of(Skill.python), List.of(Location.hanoi, Location.hochiminh), 500, 2000, "làm mình làm mẩy"));
    }

    public ConcurrentHashMap<String, Job> getAllJobs() {
        return jobs;
    }

    public ConcurrentHashMap<String, Job> addJob(JobRequest jobRequest) {
        String id = UUID.randomUUID().toString();
        jobs.put(id, new Job(id, jobRequest.getTitle(), jobRequest.getCompanyId(), jobRequest.getCompanyName(), jobRequest.getSkills(), jobRequest.getLocations(), jobRequest.getMinSalary(), jobRequest.getMaxSalary(), jobRequest.getDescription()));
        return jobs;
    }

    public ConcurrentHashMap<String, Job> deleteJob(String id) {
        jobs.remove(id);
        return jobs;
    }

    public List<Job> findByKeyWord(String keyword) {
        List<Job> list = getAllJobs().values().stream().
                filter(item -> item.getTitle().toLowerCase().contains(keyword.toLowerCase()) || item.getCompanyName().toLowerCase().contains(keyword.toLowerCase()) || item.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
        return list;
    }
}
