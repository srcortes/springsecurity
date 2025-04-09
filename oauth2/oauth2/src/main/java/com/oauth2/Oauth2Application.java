package com.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.oauth2")
public class Oauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2Application.class);
	}

}
