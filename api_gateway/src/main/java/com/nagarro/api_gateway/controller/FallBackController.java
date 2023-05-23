package com.nagarro.api_gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

	
	@GetMapping("/productServiceFallBack")
	public String productServiceFallBack() {
		return "Product service is down at this time.";
	}
	
	@GetMapping("/productDetailsServiceFallBack")
	public String productDetailsServiceFallBack() {
		return "Product Details service is down at this time.";
	}
	
	@GetMapping("/cartServiceFallBack")
	public String cartServiceFallBack() {
		return "Cart service is down at this time.";
	}
	
	@GetMapping("/adminServiceFallBack")
	public String adminServiceFallBack() {
		return "Admin service is down at this time.";
	}
	
}
