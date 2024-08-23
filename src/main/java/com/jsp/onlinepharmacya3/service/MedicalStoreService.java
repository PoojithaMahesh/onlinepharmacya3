package com.jsp.onlinepharmacya3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacya3.dao.AddressDao;
import com.jsp.onlinepharmacya3.dao.AdminDao;
import com.jsp.onlinepharmacya3.dao.MedicalStoreDao;
import com.jsp.onlinepharmacya3.dto.Address;
import com.jsp.onlinepharmacya3.dto.Admin;
import com.jsp.onlinepharmacya3.dto.MedicalStore;
import com.jsp.onlinepharmacya3.exception.AddressIdNotFoundException;
import com.jsp.onlinepharmacya3.exception.AdminIdNotFoundException;
import com.jsp.onlinepharmacya3.exception.MedicalStoreIdNotFoundException;
import com.jsp.onlinepharmacya3.util.ResponseStructure;

@Service
public class MedicalStoreService {

	@Autowired
	private MedicalStoreDao dao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AddressDao addressDao;

	public ResponseEntity<ResponseStructure<MedicalStore>> establishMedicalStore(int adminId, int addressId,
			MedicalStore medicalStore) {
		Admin dbAdmin=adminDao.findAdminById(adminId);
		if(dbAdmin!=null) {
//			admin is present and i can establish the store
			medicalStore.setAdmin(dbAdmin);
			Address dbAddress=addressDao.findAddress(addressId);
			if(dbAddress!=null) {
//				that address is the valid address
//				admin is also valid
//				now i can establish the medicalStore
				medicalStore.setAddress(dbAddress);
				MedicalStore dbMedicalStore=dao.saveMedicalStore(medicalStore);
				
				ResponseStructure<MedicalStore> structure=new  ResponseStructure<MedicalStore>();
				structure.setMessage("MedicalStore Established successfully");
				structure.setHttpStatus(HttpStatus.CREATED.value());
				structure.setData(dbMedicalStore);
				
				return new ResponseEntity<ResponseStructure<MedicalStore>>(structure,HttpStatus.CREATED);
				
				
				
			}else {
//				Address Id is not present
				throw new AddressIdNotFoundException("Sorry failed to establish the MedicalStore");
			}
		}else {
//			admin is not present
//			admin id is present
			throw new AdminIdNotFoundException("Sorry failed to establish the MedicalStore");
		}
	}

	public ResponseEntity<ResponseStructure<MedicalStore>> updateMedicalStore(int storeId, MedicalStore medicalStore) {
		MedicalStore dbMedicalStore=dao.updateMedicalStore(storeId,medicalStore);
		
		if(dbMedicalStore!=null) {
//			store is presnet and the data updated successfully
			

			ResponseStructure<MedicalStore> structure=new  ResponseStructure<MedicalStore>();
			structure.setMessage("MedicalStore Updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbMedicalStore);
			
			return new ResponseEntity<ResponseStructure<MedicalStore>>(structure,HttpStatus.OK);
			
			
			
		}else {
//			store id is not present
			throw new MedicalStoreIdNotFoundException("Sorry failed to update MedicalStore");
		}
	
		
		
	}

	public ResponseEntity<ResponseStructure<MedicalStore>> findMedicalStore(int storeId) {
		MedicalStore dbMedicalStore=dao.findMedicalStore(storeId);
		if(dbMedicalStore!=null) {
//			store is presnet and the data updated successfully
			ResponseStructure<MedicalStore> structure=new  ResponseStructure<MedicalStore>();
			structure.setMessage("MedicalStore fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbMedicalStore);
			
			return new ResponseEntity<ResponseStructure<MedicalStore>>(structure,HttpStatus.FOUND);
			
		}else {
//			store id is not present
			throw new MedicalStoreIdNotFoundException("Sorry failed to fetcch MedicalStore");
		}
	}

	public ResponseEntity<ResponseStructure<MedicalStore>> deleteMedicalStore(int storeId) {
		MedicalStore dbMedicalStore=dao.deleteMedicalStoreById(storeId);
		if(dbMedicalStore!=null) {
//			store is presnet and the data updated successfully
			ResponseStructure<MedicalStore> structure=new  ResponseStructure<MedicalStore>();
			structure.setMessage("MedicalStore deleted successfully");
			structure.setHttpStatus(HttpStatus.FORBIDDEN.value());
			structure.setData(dbMedicalStore);
			
			return new ResponseEntity<ResponseStructure<MedicalStore>>(structure,HttpStatus.FORBIDDEN);
			
		}else {
//			store id is not present
			throw new MedicalStoreIdNotFoundException("Sorry failed to delete MedicalStore");
		}
	}
}
