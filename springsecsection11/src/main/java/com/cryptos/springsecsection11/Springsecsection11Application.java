package com.cryptos.springsecsection11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class Springsecsection11Application {

    public static void main(String[] args) {
        SpringApplication.run(Springsecsection11Application.class, args);
    }

}
