package com.ecommerce.microcommerce.circuitdebreakerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
public class SpringCircuitDeBreakerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCircuitDeBreakerServiceApplication.class, args);
	}
}
