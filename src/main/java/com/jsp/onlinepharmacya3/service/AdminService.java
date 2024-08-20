package com.jsp.onlinepharmacya3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacya3.dao.AdminDao;
import com.jsp.onlinepharmacya3.dto.Admin;
import com.jsp.onlinepharmacya3.exception.AdminEmailNotValidException;
import com.jsp.onlinepharmacya3.exception.AdminIdNotFoundException;
import com.jsp.onlinepharmacya3.exception.AdminPasswordNotValidException;
import com.jsp.onlinepharmacya3.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	private AdminDao dao;

	public ResponseEntity<ResponseStructure<Admin>> signupAdmin(Admin admin) {
		Admin dbAdmin=dao.saveAdmin(admin);
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		structure.setMessage("Admin SignedUp Successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbAdmin);

	return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Admin>> loginAdmin(String email, String password) {
		Admin dbAdmin=dao.findAdminByEMail(email);
		
		if(dbAdmin!=null) {
//			if the email is present in the database 
//			then ican go further things means checking with the password
			if(dbAdmin.getPassword().equals(password)) {
//				login success 
				ResponseStructure<Admin> structure=new ResponseStructure<>();
				structure.setMessage("LOGIN SUCCESSS");
				structure.setHttpStatus(HttpStatus.OK.value());
				structure.setData(dbAdmin);
	            return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);			
			}else {
//				admin password is not valid
				throw new AdminPasswordNotValidException("Sorry failed to Login");
			}
		}else {
//			admin email is not valid
//			raise one exception called AdminEmailNotValidException
			throw new AdminEmailNotValidException("Sorry failed to Login");
		}
		
	
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(int adminId, Admin admin) {
		Admin dbAdmin=dao.updateAdmin(adminId,admin);
		if(dbAdmin!=null) {
//			id is present then data updated successfully
			ResponseStructure<Admin> structure=new ResponseStructure<>();
			structure.setMessage("Admin Updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbAdmin);
            return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);	
			
		}else {
//			id is not present
			throw new AdminIdNotFoundException("Sorry failed to Update");
		}
	}

	public ResponseEntity<ResponseStructure<Admin>> findAdminById(int adminId) {
		Admin dbAdmin=dao.findAdminById(adminId);
//		i need to do a null check or not?????????
		if(dbAdmin!=null) {
//			admin is present
			ResponseStructure<Admin> structure=new ResponseStructure<>();
			structure.setMessage("Admin fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbAdmin);
            return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.FOUND);	
		}else {
//			id is not present
			throw new AdminIdNotFoundException("sorry failed to fetch the data");
		}
	}
}
