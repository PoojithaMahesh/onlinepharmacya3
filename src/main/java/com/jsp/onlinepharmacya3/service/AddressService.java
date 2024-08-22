package com.jsp.onlinepharmacya3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacya3.dao.AddressDao;
import com.jsp.onlinepharmacya3.dto.Address;
import com.jsp.onlinepharmacya3.exception.AddressIdNotFoundException;
import com.jsp.onlinepharmacya3.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao dao;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		Address dbAddress=dao.saveAddress(address);
		ResponseStructure<Address> structure=new ResponseStructure<>();
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setMessage("Address saved successfully");
		structure.setData(dbAddress);
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(int addressId, Address address) {
		Address dbAddress=dao.updateAddress(addressId,address);
		if(dbAddress!=null) {
//			address is present then i have updated the data
			ResponseStructure<Address> structure=new ResponseStructure<>();
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setMessage("Address updated successfully");
			structure.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
		}else {
//			address id not present
			throw new AddressIdNotFoundException("Sorry failed to updateAddress");
		}
	}

	public ResponseEntity<ResponseStructure<Address>> findAddress(int addressId) {
		Address dbAddress=dao.findAddress(addressId);
		if(dbAddress!=null) {
//			Address id is present and i have fetched the data
			ResponseStructure<Address> structure=new ResponseStructure<>();
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setMessage("Address fetched successfully");
			structure.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
		}else {
//			address id is not present
			throw new AddressIdNotFoundException("Sorry failed to fetch the Address");
		}
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int addressId) {
		Address dbAddress=dao.deleteAddress(addressId);
		if(dbAddress!=null) {
//			Address id is present and i have deleted the data
			ResponseStructure<Address> structure=new ResponseStructure<>();
			structure.setHttpStatus(HttpStatus.FORBIDDEN.value());
			structure.setMessage("Address deleted successfully");
			structure.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FORBIDDEN);
		}else {
//			address id is not present
			throw new AddressIdNotFoundException("Sorry failed to delete the Address");
		}
	}
	
}
