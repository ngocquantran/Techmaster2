package com.example.hello.model.onemany.bidirection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@Entity(name = "department")
public class Department {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Department(String name) {
        this.name = name;
    }

    @OneToMany(
            mappedBy = "department",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private List<Professor> professors=new ArrayList<>();


    public void add(Professor professor){
        professor.setDepartment(this);
        professors.add(professor);
    }

    public void remove(Professor professor){
        professor.setDepartment(null);
        professors.remove(professor);
    }

    @PreRemove
    public void preRemove(){
        professors.stream().forEach(professor -> professor.setDepartment(null));
        professors.clear();
    }
}
