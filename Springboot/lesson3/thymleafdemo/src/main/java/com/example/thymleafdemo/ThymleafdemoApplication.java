package com.example.thymleafdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymleafdemoApplication {

    public static void main(String[] args) {
        System.getProperties().put( "server.port", 8282 );
        SpringApplication.run(ThymleafdemoApplication.class, args);
    }

}
