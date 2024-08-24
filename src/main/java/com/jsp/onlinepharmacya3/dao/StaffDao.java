package com.jsp.onlinepharmacya3.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.onlinepharmacya3.dto.Staff;
import com.jsp.onlinepharmacya3.repository.StaffRepo;

@Repository
public class StaffDao {

	@Autowired
	private StaffRepo repo;

	public Staff saveStaff(Staff staff) {
		return repo.save(staff);
	}

	public Staff upadateStaff(int staffId, Staff staff) {
		Optional<Staff> optional=repo.findById(staffId);
		if(optional.isPresent()) {
			
			staff.setStaffId(staffId);
			staff.setAdmin(optional.get().getAdmin());
			staff.setMedicalStore(optional.get().getMedicalStore());
			
			return repo.save(staff);
		}return null;
	}

	public Staff findStaff(int staffId) {
		Optional<Staff> optional=repo.findById(staffId);
		if(optional.isPresent()) {
			return optional.get();
		}return null;
	}

	public Staff deleteStaff(int staffId) {
		Optional<Staff> optional=repo.findById(staffId);
		if(optional.isPresent()) {
			repo.delete(optional.get());
			return optional.get();
		}return null;
	}
}
