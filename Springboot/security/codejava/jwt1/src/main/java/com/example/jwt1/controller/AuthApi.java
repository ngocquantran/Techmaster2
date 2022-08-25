package com.example.jwt1.controller;

import com.example.jwt1.jwt.JwtTokenUtil;
import com.example.jwt1.model.User;
import com.example.jwt1.request.AuthenRequest;
import com.example.jwt1.request.AuthenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthApi {
    @Autowired private AuthenticationManager authManager;

    @Autowired private JwtTokenUtil jwtTokenUtil;

    @PostMapping("auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
            User user = (User) authentication.getPrincipal();

            String accessToken = jwtTokenUtil.generateAccessToken(user);

            AuthenResponse response = new AuthenResponse(user.getEmail(), accessToken);

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }
}
