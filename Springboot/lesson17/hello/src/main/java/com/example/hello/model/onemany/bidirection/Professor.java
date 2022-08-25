package com.example.hello.model.onemany.bidirection;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    public Professor(String name){
        this.name=name;
    }

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Department department;

    @PreRemove
    public void preRemove(){
        department.remove(this);
    }
}
