package com.telmanBayram.Starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.telmanBayram")
@ComponentScan(basePackages = "com.telmanBayram")
@EnableJpaRepositories(basePackages = "com.telmanBayram")
@SpringBootApplication
public class GaleristApplication {

	public static void main(String[] args) {
		SpringApplication.run(GaleristApplication.class, args);
	}

}
