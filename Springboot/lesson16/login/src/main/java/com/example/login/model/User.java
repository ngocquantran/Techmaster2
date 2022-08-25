package com.example.login.model;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    public static User builder;
    private String id;
    private String fullName;
    private String email;
    private String hashedPassword;
    private State state;
}
