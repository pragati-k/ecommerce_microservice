package com.nagarro.admin_service.service;

import java.util.List;

import com.nagarro.admin_service.model.Admin;


public interface AdminService {

	public Admin getAdmin(Long id);

	public List<Admin> getAllAdmin();
	
	public boolean isAdmin(Admin admin);
	
	public void getAddAdmin(Admin admin);

	public void deleteAdmin(Long id);
}
