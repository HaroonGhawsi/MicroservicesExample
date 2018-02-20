package com.haroon.microservices.product_backend;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 * @author haroon.ghawsi
 *
 */
@Configuration
public class ApplicationConfig {
	
	@Named
	static class JerseyConfig extends ResourceConfig{
		public JerseyConfig(){
			this.packages("com.haroon.microservices.product_backend.rest");
		}
	}

}
