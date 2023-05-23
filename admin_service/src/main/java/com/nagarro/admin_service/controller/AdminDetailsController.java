package com.nagarro.admin_service.controller;

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
import com.nagarro.admin_service.model.Admin;
import com.nagarro.admin_service.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminDetailsController {

	@Autowired
	private AdminService adminService;
	
	Logger log
    = LoggerFactory.getLogger(AdminDetailsController.class);
	
	@GetMapping("/allAdmins")
	public List<Admin> getAllAdmins() throws JsonProcessingException{
		
		List<Admin> admins = this.adminService.getAllAdmin();
		log.info("Got all admins: {}", new ObjectMapper().writeValueAsString(admins));
		return admins;

	}
	
	@GetMapping("/{adminId}")
	public Admin getAdmin(@PathVariable("adminId") Long adminId){
		
		Admin admin = this.adminService.getAdmin(adminId);
		log.info("Got admin od id: {}", adminId);
		return admin;

	}
	
	@PostMapping("/isAdmin")
	public boolean isAdmin(@RequestBody Admin admin){
		
		boolean isadmin =  this.adminService.isAdmin(admin);
		log.info("Is admin? {}", isadmin);
		return isadmin;
		
	}
	@PostMapping(value = "/addAdmin", consumes = "application/json", produces = "application/json")
	public void getAddProducts(@RequestBody Admin admin) throws JsonProcessingException {
		
		this.adminService.getAddAdmin(admin);
		log.info("Added admin: {}", new ObjectMapper().writeValueAsString(admin));

		
	}
	
	@DeleteMapping("/deleteAdmin/{adminId}")
	public void getDeleteAdmin(@PathVariable("adminId") Long adminId){
		
		this.adminService.deleteAdmin(adminId);
		log.info("Removed admin with id: {}", adminId);
	}
	
}
