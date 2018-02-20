package com.haroon.microservices.order_backend;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author haroon.ghawsi
 *
 */
@Configuration
public class ApplicationConfig {
	
	@Named
	static class JerseyConfig extends ResourceConfig{
		public JerseyConfig(){
			this.packages("com.haroon.microservices.order_backend.rest");
		}
	}
	
	@Bean
	public RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}

}
