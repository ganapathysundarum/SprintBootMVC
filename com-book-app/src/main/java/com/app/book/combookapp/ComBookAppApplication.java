package com.app.book.combookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.app")
public class ComBookAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComBookAppApplication.class, args);
	}

}
