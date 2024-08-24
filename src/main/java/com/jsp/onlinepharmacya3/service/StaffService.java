package com.jsp.onlinepharmacya3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacya3.dao.AdminDao;
import com.jsp.onlinepharmacya3.dao.MedicalStoreDao;
import com.jsp.onlinepharmacya3.dao.StaffDao;
import com.jsp.onlinepharmacya3.dto.Admin;
import com.jsp.onlinepharmacya3.dto.MedicalStore;
import com.jsp.onlinepharmacya3.dto.Staff;
import com.jsp.onlinepharmacya3.exception.AdminIdNotFoundException;
import com.jsp.onlinepharmacya3.exception.MedicalStoreIdNotFoundException;
import com.jsp.onlinepharmacya3.exception.StaffIdNotFoudException;
import com.jsp.onlinepharmacya3.util.ResponseStructure;

@Service
public class StaffService {

	@Autowired
	private StaffDao dao;

	@Autowired
	private AdminDao adminDao;
	@Autowired
	private MedicalStoreDao storeDao;
	
	public ResponseEntity<ResponseStructure<Staff>> signupStaff(int adminId, int storeId, Staff staff) {
		Admin dbAdmin=adminDao.findAdminById(adminId);
		if(dbAdmin!=null) {
//			Admin is present
			staff.setAdmin(dbAdmin);
			MedicalStore dbMedicalStore=storeDao.findMedicalStore(storeId);
			if(dbMedicalStore!=null) {
//				store is present
				staff.setMedicalStore(dbMedicalStore);
				Staff dbStaff=dao.saveStaff(staff);
				ResponseStructure<Staff> structure=new ResponseStructure<Staff>();
				structure.setMessage("Staff SignedUp successfully");
				structure.setHttpStatus(HttpStatus.CREATED.value());
				structure.setData(dbStaff);
				return new ResponseEntity<ResponseStructure<Staff>>(structure,HttpStatus.CREATED);
			}else {
				throw new MedicalStoreIdNotFoundException("Sorry failed to signupAdmin");
			}
			
		}else {
			throw new AdminIdNotFoundException("Sorry failed to signup Staff");
		}
		
	}

	public ResponseEntity<ResponseStructure<Staff>> updateStaff(int staffId, Staff staff) {
		Staff dbStaff=dao.upadateStaff(staffId,staff);
		if(dbStaff!=null) {
			ResponseStructure<Staff> structure=new ResponseStructure<Staff>();
			structure.setMessage("Staff Updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbStaff);
			return new ResponseEntity<ResponseStructure<Staff>>(structure,HttpStatus.OK);
			
		}else {
//			stff is null means staff id is not found
			throw new StaffIdNotFoudException("Sorry failed to update Staff");
		}
		
	}

	public ResponseEntity<ResponseStructure<Staff>> findStaff(int staffId) {
		Staff dbStaff=dao.findStaff(staffId);
		if(dbStaff!=null) {
			ResponseStructure<Staff> structure=new ResponseStructure<Staff>();
			structure.setMessage("Staff fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbStaff);
			return new ResponseEntity<ResponseStructure<Staff>>(structure,HttpStatus.FOUND);
			
		}else {
//			stff is null means staff id is not found
			throw new StaffIdNotFoudException("Sorry failed to fetch Staff");
		}
	}

	public ResponseEntity<ResponseStructure<Staff>> deleteStaff(int staffId) {
		Staff dbStaff=dao.deleteStaff(staffId);
		if(dbStaff!=null) {
			ResponseStructure<Staff> structure=new ResponseStructure<Staff>();
			structure.setMessage("Staff deleted successfully");
			structure.setHttpStatus(HttpStatus.FORBIDDEN.value());
			structure.setData(dbStaff);
			return new ResponseEntity<ResponseStructure<Staff>>(structure,HttpStatus.FORBIDDEN);
			
		}else {
//			stff is null means staff id is not found
			throw new StaffIdNotFoudException("Sorry failed to delete Staff");
		}
	}
}
