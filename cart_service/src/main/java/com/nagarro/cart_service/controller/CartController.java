package com.nagarro.cart_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.cart_service.model.Product;
import com.nagarro.cart_service.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private RestTemplate restTemplate;
	

	 Logger log
    = LoggerFactory.getLogger(CartController.class);
	
	@GetMapping("/allCart")
	public List<Product> getAllProduct() throws JsonProcessingException{
		
		List<Product> plist = this.cartService.getCart();
		log.info("Got all products: {}", new ObjectMapper().writeValueAsString(plist));
		return plist;
	}
	
	@PostMapping("/addCart/{productId}")
	public void getAddProduct(@PathVariable("productId") Long productId) throws JsonProcessingException{
		
		try {
			Product product = this.restTemplate.getForObject("http://product-service/product/" + productId, Product.class);
			this.cartService.addToCart(product);
			log.info("Product {} added to the Cart", new ObjectMapper().writeValueAsString(product));
		} catch (RestClientException e) {
			e.printStackTrace();
			log.error("Product service down");
		}

	}
	
	@DeleteMapping("/deleteCart/{productId}")
	public void deleteCartProduct(@PathVariable("productId") Long productId) {
		this.cartService.removeFromCart(productId);
		log.info("Product id {} removed from the Cart", productId);
	}
	
	@DeleteMapping("/removeCart")
	public void deleteAllCart() {
		this.cartService.removeAll();
		log.info("Removed all products from  Cart");
	}
	
}
