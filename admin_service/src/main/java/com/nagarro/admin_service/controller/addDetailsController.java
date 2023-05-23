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

import com.nagarro.admin_service.model.ProductDetails;


@RestController
@RequestMapping("/admin")
public class addDetailsController {

	@Autowired
	private RestTemplate restTemplate;
	
	 Logger log
	    = LoggerFactory.getLogger(addDetailsController.class);
	
	@PostMapping("/addDetails")
	public void getAddProduct(@RequestBody ProductDetails productDetails){
		
		try {this.restTemplate.postForObject("http://product-details-service/details/addDetails", productDetails, ProductDetails.class);
		} catch (RestClientException e) {
			e.printStackTrace();
			log.error("Details service down");
		}

	}
	
	@DeleteMapping("/deleteDetails/{detailsId}")
	public void getDeleteProduct(@PathVariable("detailsId") Long detailsId){
		
		try {
			
			this.restTemplate.delete("http://product-details-service/details/deleteDetails/"+detailsId);
		} catch (RestClientException e) {

			e.printStackTrace();
			log.error("Details service down");

		}

	}
	
}
