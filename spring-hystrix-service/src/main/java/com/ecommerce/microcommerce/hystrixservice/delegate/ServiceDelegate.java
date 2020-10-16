package com.ecommerce.microcommerce.hystrixservice.delegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ServiceDelegate {
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "callServiceAndGetData_Fallback")
	public String callServiceAndGetData(int id) {
		System.out.println("Getting details for " + id);
		String response = restTemplate
				.exchange("http://localhost:9090/Produits/{id}"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}, id).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - id -  " + id + " :::  Details " + response + " -  " + new Date();
	}
	
	@SuppressWarnings("unused")
	private String callServiceAndGetData_Fallback(int id) {
		System.out.println("Service is down!!! fallback route enabled...");
		return "CIRCUIT BREAKER ENABLED!!!No Response From Service at this moment. Service will be back shortly - " + new Date();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
