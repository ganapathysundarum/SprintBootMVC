package com.product.app.comproductapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.product.app")
@EnableJpaRepositories("com.product.app")
@EntityScan("com.product.app")
public class ComProductAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComProductAppApplication.class, args);
	}

}
