package com.example.demo.customrepo;

import com.example.demo.model.Person;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface PersonRepoCustom {
    Map<String, List<Person>> groupPeopleByCity();
    TreeMap<String,List<Person>> groupPeopleOrderByCity();

    Map<String,CityJobCount> topJobInCity();

    TreeMap<String, List<JobCount>> countAllTopJobsInCity();

    Map<String,Integer> averageJobAge();

    LinkedHashMap<String,Integer> topAvarageJobAge(int top);
}
