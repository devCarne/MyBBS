package com.example.mybbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MyBbsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBbsApplication.class, args);
    }

}
