package com.jsp.onlinepharmacya3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.onlinepharmacya3.dto.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
