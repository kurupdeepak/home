package com.rxtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.rxtracker")
public class PrescriptionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrescriptionServiceApplication.class, args);
	}

}
