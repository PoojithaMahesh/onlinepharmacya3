package com.jsp.onlinepharmacya3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.onlinepharmacya3.dto.Staff;
import com.jsp.onlinepharmacya3.service.StaffService;
import com.jsp.onlinepharmacya3.util.ResponseStructure;

@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private StaffService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Staff>> signUpStaff(@RequestParam int adminId,
			@RequestParam int storeId,@RequestBody Staff staff){
		return service.signupStaff(adminId,storeId,staff);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@RequestParam int staffId,@RequestBody Staff staff){
		return service.updateStaff(staffId,staff);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Staff>> findStaff(@RequestParam int staffId){
		return service.findStaff(staffId);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Staff>> deleteStaff(@RequestParam int staffId){
		return service.deleteStaff(staffId);
	}
}

