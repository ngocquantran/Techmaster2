package com.example.demo.model.id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Bar {
    @Id
    @GeneratedValue(generator = "random_id")
    @GenericGenerator(name = "random_id",strategy = "com.example.demo.model.id.RandomIDGenerator")
    private String id;
    private String name;
}
