package com.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.products.infrastructure.repositories")
@ComponentScan(basePackages = {"com.products"})
@EntityScan("com.products.infrastructure.entities")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

}
