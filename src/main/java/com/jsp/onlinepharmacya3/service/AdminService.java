package com.jsp.onlinepharmacya3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacya3.dao.AdminDao;
import com.jsp.onlinepharmacya3.dto.Admin;
import com.jsp.onlinepharmacya3.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	private AdminDao dao;

	public ResponseEntity<ResponseStructure<Admin>> signupAdmin(Admin admin) {
		Admin dbAdmin=dao.saveAdmin(admin);
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		structure.setMessage("Admin SignedUp Successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbAdmin);

	return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.CREATED);
	}
}
