package com.ecommerce.microcommerce.circuitdebreakerservice.delegate;

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
	public String callServiceAndGetData() {
		String response = restTemplate
				.exchange("http://localhost:9090/Produits"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!!   " + " :::  Details " + response + " -  " + new Date();
	}
	
	@HystrixCommand(fallbackMethod = "callServiceAndGetDataById_Fallback")
	public String callServiceAndGetDataById(int id) {
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
	
	@HystrixCommand(fallbackMethod = "callServiceAndGetDataAdmin_Fallback")
	public String callServiceAndGetDataAdmin() {
		String response = restTemplate
				.exchange("http://localhost:9090/AdminProduits"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!!    " + " :::  Details " + response + " -  " + new Date();
	}
	
	@HystrixCommand(fallbackMethod = "callServiceAndGetDataTri_Fallback")
	public String callServiceAndGetDataTri() {
		String response = restTemplate
				.exchange("http://localhost:9090/OrdreAlpha"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!!    " + " :::  Details " + response + " -  " + new Date();
	}
	
	@SuppressWarnings("unused")
	private String callServiceAndGetData_Fallback() {
		System.out.println("Service is down!!! fallback route enabled...");
		return "CIRCUIT BREAKER ENABLED!!!No Response From Service at this moment. Service will be back shortly - " + new Date();
	}
	
	@SuppressWarnings("unused")
	private String callServiceAndGetDataById_Fallback(int id) {
		System.out.println("Service is down!!! fallback route enabled...");
		return "CIRCUIT BREAKER ENABLED!!!No Response From Service at this moment. Service will be back shortly - " + new Date();
	}
	
	@SuppressWarnings("unused")
	private String callServiceAndGetDataAdmin_Fallback() {
		System.out.println("Service is down!!! fallback route enabled...");
		return "CIRCUIT BREAKER ENABLED!!!No Response From Service at this moment. Service will be back shortly - " + new Date();
	}
	
	@SuppressWarnings("unused")
	private String callServiceAndGetDataTri_Fallback() {
		System.out.println("Service is down!!! fallback route enabled...");
		return "CIRCUIT BREAKER ENABLED!!!No Response From Service at this moment. Service will be back shortly - " + new Date();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
