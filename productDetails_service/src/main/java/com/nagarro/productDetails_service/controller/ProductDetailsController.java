package com.nagarro.productDetails_service.controller;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.productDetails_service.model.ProductDetails;
import com.nagarro.productDetails_service.service.ProductDetailsService;

@RestController
@RequestMapping("/details")
public class ProductDetailsController {

	@Autowired
	private ProductDetailsService productDetailsService;
	

	 Logger log
       = LoggerFactory.getLogger(ProductDetailsController.class);
	
	@GetMapping("/allDetails")
	public List<ProductDetails> getAllDetails() throws JsonProcessingException {
			List<ProductDetails> plist = this.productDetailsService.getAllDetails();
	        log.info("Product-details-service - Got all Details: {}", new ObjectMapper().writeValueAsString(plist));
	        return plist;
		
	}
	
	@GetMapping("/product/{productId}")
	public List<ProductDetails> getProduct(@PathVariable("productId") Long productId) throws JsonProcessingException {
		
		List<ProductDetails> plist = this.productDetailsService.getProductDetails(productId);
        log.info("Product-details-service - Got all Details of a single product: {}", new ObjectMapper().writeValueAsString(plist));
		return plist;
		
	}
	
//	@PostMapping("/addDetails")
	@PostMapping(value = "/addDetails", consumes = "application/json", produces = "application/json")
	public void getAddProducts(@RequestBody ProductDetails details) {
		
		this.productDetailsService.getAddDetails(details);
        log.info("Product-details-service - Added details to product id {}", details.getProductId());
	}
	
	@DeleteMapping("/deleteDetails/{detailsId}")
	public void deleteDetails(@PathVariable("detailsId") Long detailsId) {
		
		this.productDetailsService.deleteDetails(detailsId);
        log.info("Product-details-service - Deleted details of id {}", detailsId);

	}
	
	@DeleteMapping("/deleteAccToProduct/{detailsId}")
	public void deleteAccToProduct(@PathVariable("detailsId") Long detailsId) {
		
		this.productDetailsService.deleteAccToProduct(detailsId);
        log.info("Product-details-service - Deleted all details acc to product");

	}
}
