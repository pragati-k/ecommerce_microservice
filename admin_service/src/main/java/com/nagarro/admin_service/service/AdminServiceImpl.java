package com.nagarro.admin_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nagarro.admin_service.model.Admin;

@Service
public class AdminServiceImpl implements AdminService{

	
	//fake product list	
	List<Admin> list = new ArrayList<>(List.of(
			new Admin(1L, "xxx", "xxx"),
			new Admin(2L, "eren", "eren")
			));
	
	@Override
	public Admin getAdmin(Long id) {

		return this.list.stream().filter(admin -> admin.getAdminID() == id).findAny().orElse(null);
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return this.list;
	}

	@Override
	public void getAddAdmin(Admin admin) {
		this.list.add(admin);
		
	}

	@Override
	public void deleteAdmin(Long id) {
		
		this.list.removeIf(admin -> admin.getAdminID() == id);
		
	}

	@Override
	public boolean isAdmin(Admin admin) {
		List<Admin> result = this.list.stream().filter(a ->{
			if(a.getUsername().equals(admin.getUsername()) && a.getPassword().equals(admin.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}).collect(Collectors.toList());
		return result.size() > 0;
	}

}
