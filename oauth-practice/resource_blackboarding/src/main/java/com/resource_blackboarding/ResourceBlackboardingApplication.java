package com.resource_blackboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.resource_blackboarding")
public class ResourceBlackboardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceBlackboardingApplication.class);
	}

}
