package com.jsp.onlinepharmacya3.dao;

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
}
