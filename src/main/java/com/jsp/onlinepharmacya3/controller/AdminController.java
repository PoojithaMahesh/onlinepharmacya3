package com.jsp.onlinepharmacya3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.onlinepharmacya3.dto.Admin;
import com.jsp.onlinepharmacya3.service.AdminService;
import com.jsp.onlinepharmacya3.util.ResponseStructure;

@RestController
public class AdminController {

	@Autowired
	private AdminService service;
	
	@PostMapping("/signup")
	public ResponseEntity<ResponseStructure<Admin>> signupAdmin(@RequestBody Admin admin){
		
		return service.signupAdmin(admin);
	} 
	
	
}
