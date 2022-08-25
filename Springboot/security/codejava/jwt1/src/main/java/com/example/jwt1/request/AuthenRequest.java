package com.example.jwt1.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenRequest {
    @Email @Length(min = 5,max = 50)
    private String email;
    @Length(min = 5,max = 10)
    private String password;
}
