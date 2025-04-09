package com.jwtauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jwtauthserver")
public class JwtAuthorizationServer {

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthorizationServer.class);

    }
}
