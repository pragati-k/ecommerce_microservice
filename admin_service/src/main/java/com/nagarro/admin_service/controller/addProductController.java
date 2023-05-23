package com.nagarro.admin_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.nagarro.admin_service.model.Product;


@RestController
@RequestMapping("/admin")
public class addProductController {

	@Autowired
	private RestTemplate restTemplate;
	
	 Logger log
	    = LoggerFactory.getLogger(addProductController.class);
	
	@PostMapping("/addProducts")
	public void getAddProduct(@RequestBody Product product){
		
		try {
			
			this.restTemplate.postForObject("http://product-service/product/addProducts", product, Product.class);
		} catch (RestClientException e) {

			e.printStackTrace();
			log.error("Product service down");
		}

	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public void getDeleteProduct(@PathVariable("productId") Long productId){
		
		try {
			
			this.restTemplate.delete("http://product-service/product/deleteProduct/"+productId);
		} catch (RestClientException e) {
			
			e.printStackTrace();
			log.error("Product service down");
		}

	}
	
}
