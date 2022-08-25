package com.example.login.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record LoginRequest(
        @NotBlank(message = "Email cannot blank")
        @Email(message = "Invalid emal")
        String email,

        @Size(min = 5, max = 20, message = "Password length from 8 to 16 characters")
        String password
) {

}
