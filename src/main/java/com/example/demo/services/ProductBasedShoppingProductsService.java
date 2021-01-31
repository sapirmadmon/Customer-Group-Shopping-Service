package com.example.demo.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.boundaries.ProductBoundary;
import com.example.demo.exceptions.EmptyProductException;

@Component
public class ProductBasedShoppingProductsService {

	private RestTemplate restTemplate;
	private String url;
	private String host;
	private int port;

	
	@Value("${productport:8083}")
	public void setPort(String port) {
		this.port = Integer.parseInt(port);
	}


	@Value("${userHost:localhost}")
	public void setHost(String host) {
		this.host = host;
	}



	@PostConstruct
	public void init() {
		this.restTemplate = new RestTemplate();

		//this.url = "http://localhost:" + port + "/shopping/products/{productId}";
		this.url = "http://" + host + ":" + port;
	}

	public void getProductFromShoppingProductsManagement(Long productId) {
		ResponseEntity<ProductBoundary> product;
		try {
			product = restTemplate.getForEntity(this.url + "/shopping/products/{productId}", ProductBoundary.class, productId);

		} catch (Exception e) {
			throw new EmptyProductException("The product does not exist in the system");
		}

		if(product.getStatusCode() != HttpStatus.OK || product.getBody() == null) {
			//return product.getBody();
			throw new EmptyProductException("The product does not exist in the system");
		}

	}

}
