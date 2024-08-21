package com.jsp.onlinepharmacya3.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.onlinepharmacya3.dto.Admin;
import com.jsp.onlinepharmacya3.repository.AdminRepo;

@Repository
public class AdminDao {

	@Autowired
	private AdminRepo repo;

	public Admin saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return repo.save(admin);
	}

	public Admin findAdminByEMail(String email) {
		Optional<Admin> optional=repo.findByEmail(email);
		if(optional.isPresent()) {
//			something is present inside the option
//			something is nothing but your admin
//			means your admin is present
			return optional.get();
		}else {
			return null;
		}
	}

	public Admin updateAdmin(int adminId, Admin admin) {
//		first i need to check whether this admin is present or not
		Optional<Admin> optional=repo.findById(adminId);
		if(optional.isPresent()) {
//			admin is present so i can update the admin
//			things that i need to set before updating the details
//			1.set the Id here
//			2.if any reltaionship entities are present i need to set that one
			admin.setAdminId(adminId);
			return repo.save(admin);
		}else {
			return null;
//			admin is not present
		}
	}

	public Admin findAdminById(int adminId) {
	Optional<Admin> optional=repo.findById(adminId);
	if(optional.isPresent()) {
//		admin is present
		return optional.get();
	}else {
//		admin is not present with this id
		return null;
	}
	}

	public Admin deleteAdminById(int adminId) {
		Optional<Admin> optional=repo.findById(adminId);
		if(optional.isPresent()) {
//			admin is presnet now i can delete the data;
			
			 repo.deleteById(adminId);
 			return optional.get();
		}else {
			return null;
			
		}
	}
}
