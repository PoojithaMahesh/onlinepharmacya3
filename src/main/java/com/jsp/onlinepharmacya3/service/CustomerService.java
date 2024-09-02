package com.jsp.onlinepharmacya3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacya3.dao.AddressDao;
import com.jsp.onlinepharmacya3.dao.CustomerDao;
import com.jsp.onlinepharmacya3.dto.Address;
import com.jsp.onlinepharmacya3.dto.Customer;
import com.jsp.onlinepharmacya3.exception.AddressIdNotFoundException;
import com.jsp.onlinepharmacya3.util.ResponseStructure;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;
	@Autowired
	private AddressDao addressDao;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(int addressId, Customer customer) {
		Address dbAddress=addressDao.findAddress(addressId);
		if(dbAddress!=null) {
//			set address to the customer
			List<Address> addresses=new ArrayList<Address>();
			addresses.add(dbAddress);
			customer.setAddresses(addresses);
			Customer dbCustomer=dao.saveCustomer(customer);
			dbAddress.setCustomer(customer);
			ResponseStructure<Customer> structure=new ResponseStructure<>();
			structure.setMessage("Customer Signed up successfully");
			structure.setHttpStatus(HttpStatus.CREATED.value());
			structure.setData(dbCustomer);
			return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.CREATED);
		}else {
			throw new AddressIdNotFoundException("Sorry Failed to signup customer");
		}
	}
}
