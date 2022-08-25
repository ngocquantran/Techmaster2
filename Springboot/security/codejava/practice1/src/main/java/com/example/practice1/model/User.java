package com.example.practice1.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 45)
    private String email;

    @Column(nullable = false,length = 64)
    private String password;

    @Column(nullable = false,length = 45)
    private String firstName;

    @Column(nullable = false,length = 45)
    private String lastName;
}
