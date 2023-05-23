package com.nagarro.api_gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.nagarro.api_gateway.model.Admin;



@RestController
public class AuthController {

	@Autowired
	private RestTemplate restTemplate;
	
	Logger log = LoggerFactory.getLogger(AuthController.class);
	
	@PostMapping("/signIn")
	public String getAdmin(@RequestBody Admin admin){
		String result = "Wrong username and password";
		
		try {
			
			ResponseEntity<Admin[]> responseEntity = restTemplate.getForEntity("http://admin-service/admin/allAdmins", Admin[].class);
			Admin[] res = responseEntity.getBody();
			for(Admin a: res) {
				if(a.getUsername().equals(admin.getUsername()) && a.getPassword().equals(admin.getPassword())) {
					result = "Admin Logged in";
				}
			}
		} catch (RestClientException e) {
			
			e.printStackTrace();
			log.error("Admin service down");
		}
		return result;
	}
	
}
