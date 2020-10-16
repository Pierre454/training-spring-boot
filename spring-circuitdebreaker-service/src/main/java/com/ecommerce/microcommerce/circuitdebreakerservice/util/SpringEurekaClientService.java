package com.ecommerce.microcommerce.circuitdebreakerservice.util;

import java.util.Collections;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class SpringEurekaClientService implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("details",
				Collections.singletonMap("description", "This is the service, which is discovery server aware, and this service will Call Microservice, fro details, which is again dicovery server aware!!! "));
	}

}
