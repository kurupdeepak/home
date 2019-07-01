package com.rxtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.rxtracker")
@RestController
public class PrescriptionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrescriptionServiceApplication.class, args);
	}

	@GetMapping ("/info")
	public String info() {
		return "Prescription Management Service " ;
	}
}
