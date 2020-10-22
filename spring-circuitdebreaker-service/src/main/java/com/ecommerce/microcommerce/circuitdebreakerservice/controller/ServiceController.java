package com.ecommerce.microcommerce.circuitdebreakerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.microcommerce.circuitdebreakerservice.delegate.ServiceDelegate;

@RestController
public class ServiceController {
	
	@Autowired
    ServiceDelegate serviceDelegate;

	@RequestMapping(value = "/Produits", method = RequestMethod.GET)
	public String getProduits() {
		System.out.println("Going to get data!");
		return serviceDelegate.callServiceAndGetData();
	}

	@RequestMapping(value = "/Produits/{id}", method = RequestMethod.GET)
	public String getProduitsById(@PathVariable int id) {
		System.out.println("Going to get data!");
		return serviceDelegate.callServiceAndGetDataById(id);
	}
	
	@RequestMapping(value = "/AdminProduits", method = RequestMethod.GET)
	public String getProduitsAdmin() {
		System.out.println("Going to get data!");
		return serviceDelegate.callServiceAndGetDataAdmin();
	}
	
	@RequestMapping(value = "/OrdreAlpha", method = RequestMethod.GET)
	public String getProduitsTri() {
		System.out.println("Going to get data!");
		return serviceDelegate.callServiceAndGetDataTri();
	}	
}
