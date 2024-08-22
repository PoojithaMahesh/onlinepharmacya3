package com.jsp.onlinepharmacya3.controller;

import org.hibernate.annotations.processing.Find;
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

import com.jsp.onlinepharmacya3.dto.Address;
import com.jsp.onlinepharmacya3.service.AddressService;
import com.jsp.onlinepharmacya3.util.ResponseStructure;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService service;
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address){
		return service.saveAddress(address);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam int addressId,@RequestBody Address address){
		return service.updateAddress(addressId,address);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Address>> findAddress(@RequestParam int addressId){
		return service.findAddress(addressId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam int addressId){
		return service.deleteAddress(addressId);
	}
	
}
