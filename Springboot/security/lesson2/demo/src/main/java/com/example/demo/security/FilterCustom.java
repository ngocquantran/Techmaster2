package com.example.demo.security;

import com.example.demo.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FilterCustom extends OncePerRequestFilter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Lấy thông tin username (email) trong session
        String userEmail = (String) request.getSession().getAttribute("MY_SESSION");
        if (userEmail == null) {
            filterChain.doFilter(request, response);
            return;
        }

        //Lấy ra thông tin của user theo email
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(userEmail);

        //Tạo đối tượng xác thực
        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(userEmail);
        if (authenticationToken == null) {
            filterChain.doFilter(request, response);
            return;
        }
        //Lưu ào trong context
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);

    }

    public UsernamePasswordAuthenticationToken getAuthentication(String email) {
        if (email == null) {
            return null;
        }

        //Lấy ra thông tin của user theo email
        UserDetails user = customUserDetailsService.loadUserByUsername(email);

        //Tạo ra đối tuwowjgn xác thực
        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }
}
