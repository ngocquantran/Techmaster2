package com.example.demo.customrepo;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PersonRepoImpl implements PersonRepoCustom{
    @Autowired PersonRepository personRepo;
    @PersistenceContext
    private EntityManager em;

    @Override
    public Map<String, List<Person>> groupPeopleByCity() {
        return personRepo.findAll().stream().collect(Collectors.groupingBy(Person::getCity));
    }

    @Override
    public TreeMap<String, List<Person>> groupPeopleOrderByCity() {
        return personRepo.findAll().stream()
                .collect(Collectors.groupingBy(Person::getCity,TreeMap::new,Collectors.toList()));
    }

    @Override
    public Map<String, CityJobCount> topJobInCity() {
        return null;
    }

    @Override
    public TreeMap<String, List<JobCount>> countAllTopJobsInCity() {
        return null;
    }

    @Override
    public Map<String, Integer> averageJobAge() {
        return null;
    }

    @Override
    public LinkedHashMap<String, Integer> topAvarageJobAge(int top) {
        return null;
    }
}
