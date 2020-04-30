package com.cognizant.ormlearn.springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.cognizant.ormlearn.springdatajpa"})
public class OrmLearnWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnWebApplication.class, args);
	}

}
