package com.haroon.microservices.order_backend.rest;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.web.client.RestTemplate;

/**
 * @author haroon.ghawsi
 *
 */

@Named
@Path("/")
public class OrderRest {
	
	private long id = 1;
	
	/**
	 * RestTemplate facilitates the consumption of REST services
	 */
	
	@Inject
	private RestTemplate restTemplate;
	
	/**
	 * Get request to create a new customer and product and returns the order.
	 * @param idCustomer customer id
	 * @param idProduct product id
	 * @param amount amount
	 * @return order
	 */
	
	@GET
	@Path("order")
	@Produces(MediaType.APPLICATION_JSON)
	public Order submitOrder(@QueryParam("idCustomer")long idCustomer, @QueryParam("idProduct") long idProduct, @QueryParam("amount") long amount){
		
		Order order = new Order();
		Customer customer = restTemplate.getForObject("http://localhost:8081/customer?id={id}", Customer.class, idCustomer);
		Product product = restTemplate.getForObject("http://localhost:8082/product?id={id}", Product.class, idProduct);
		order.setCustomer(customer);
		order.setProduct(product);
		order.setId(id);
		order.setAmount(amount);
		order.setDateOrder(new Date());
		id++;
		
		return order;
	}
	
}
