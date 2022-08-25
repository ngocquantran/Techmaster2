package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "person")
@Table(name = "person")
public class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String job;
    private String gender;
    private String city;
    private int salary;
    private LocalDate birthday;

    @Column(name = "sex")
    @Formula(value = "case when gender='Male' then true else false end")
    private Boolean sex;

    @Transient
    private int age;

    public int getAge() {
        LocalDate curDate=LocalDate.now();
        return Period.between(birthday,curDate).getYears();
    }

    public Person(String name, String job, String gender, String city, int salary, LocalDate birthday) {
        this.name = name;
        this.job = job;
        this.gender = gender;
        this.city = city;
        this.salary = salary;
        this.birthday = birthday;

    }
}
