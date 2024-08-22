package com.jsp.onlinepharmacya3.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.onlinepharmacya3.dto.Address;
import com.jsp.onlinepharmacya3.repository.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepo repo;

	public Address saveAddress(Address address) {
		return repo.save(address);
	}

	public Address updateAddress(int addressId, Address address) {
	Optional<Address> optional=repo.findById(addressId);
	if(optional.isPresent()) {
		address.setAddressId(addressId);
		address.setCustomer(optional.get().getCustomer());
		address.setMedicalStore(optional.get().getMedicalStore());
		return repo.save(address);
		
	}else {
		return null;
	}
	}

	public Address findAddress(int addressId) {
	Optional<Address> optional=repo.findById(addressId);
	if(optional.isPresent()) {
//		address is present
		return optional.get();
	}else {
		return null;
	}
	}

	public Address deleteAddress(int addressId) {
		Optional<Address> optional=repo.findById(addressId);
		if(optional.isPresent()) {
//			address is present
			repo.delete(optional.get());
			return optional.get();
		}else {
			return null;
		}
	}
}
