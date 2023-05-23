package com.nagarro.api_gateway.model;

public class Admin {
	
	
	private Long adminID;
	private String username;
	private String password;
	
	
	public Admin() {
	}
	
	public Admin(Long adminId, String username, String password) {
	
		this.adminID = adminId;
		this.username = username;
		this.password = password;
	}
	
	
	public Long getAdminID() {
		return adminID;
	}

	public void setAdminID(Long adminID) {
		this.adminID = adminID;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
