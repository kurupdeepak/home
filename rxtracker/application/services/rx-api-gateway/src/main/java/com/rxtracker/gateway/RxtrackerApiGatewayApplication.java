package com.rxtracker.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class RxtrackerApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(RxtrackerApiGatewayApplication.class, args);
	}

}
