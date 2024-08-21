package com.jsp.onlinepharmacya3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<Admin>> loginAdmin(@RequestParam String email,@RequestParam String password){
		return service.loginAdmin(email,password);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestParam int adminId,@RequestBody Admin admin){
		return service.updateAdmin(adminId,admin);
	}
	
	@GetMapping("/get")
	public ResponseEntity<ResponseStructure<Admin>> findAdminById(@RequestParam int adminId){
		return service.findAdminById(adminId);
	}
	
//	reset password=email,newpassword,phonenumber
//	delete:::::::::::::101%
	
	@PostMapping("/resetpassword")
	public ResponseEntity<ResponseStructure<Admin>> resetAdminPassword(@RequestParam String email,
			@RequestParam String newPassword,@RequestParam long phone){
		return service.resetPassword(email,newPassword,phone);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Admin>> deleteAdminById(@RequestParam int adminId){
		return service.deleteAdminById(adminId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
