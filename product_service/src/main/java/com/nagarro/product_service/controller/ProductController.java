package com.nagarro.product_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.product_service.model.Product;
import com.nagarro.product_service.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	 Logger log
     = LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping("/allProducts")
	public List<Product> getAllProduct() throws JsonProcessingException{
	
		List<Product> products = this.productService.getAllProduct();
		try {
			products.forEach(product -> {
				List details = this.restTemplate.getForObject("http://product-details-service/details/product/" + product.getProductId(), List.class);
				product.setDetails_list(details);
			});
			log.info("Got all products: {}", new ObjectMapper().writeValueAsString(products));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Details service down");
		}
		return products;
	}
	
	@GetMapping("/{productId}")
	public Product getProduct(@PathVariable("productId") Long productId) {
		
		Product product = this.productService.getProduct(productId);
		try {
			List details = this.restTemplate.getForObject("http://product-details-service/details/product/" + product.getProductId(), List.class);
			product.setDetails_list(details);
			log.info("Got product of id: {}", productId);
		} catch (RestClientException e) {
			e.printStackTrace();
			log.error("Details service down");
		}
		return product;
		
	}
	
	@PostMapping(value = "/addProducts", consumes = "application/json", produces = "application/json")
	public void getAddProducts(@RequestBody Product product) throws JsonProcessingException {
		
		this.productService.getAddProduct(product);
		log.info("Added product: {}", new ObjectMapper().writeValueAsString(product));
		
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public void deleteDetails(@PathVariable("productId") Long productId) {
		
		try {
			
			this.restTemplate.delete("http://product-details-service/details/deleteAccToProduct/" + productId);
			this.productService.deleteProduct(productId);
			log.info("Deleted product with id: {}", productId);
		} catch (RestClientException e) {
			
			e.printStackTrace();
			log.error("Details service down");
		}
	}
	
}
