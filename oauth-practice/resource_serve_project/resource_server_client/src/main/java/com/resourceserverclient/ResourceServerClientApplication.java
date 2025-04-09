package com.resourceserverclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@ComponentScan("com.resourceserverclient")
public class ResourceServerClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServerClientApplication.class);
	}

}
