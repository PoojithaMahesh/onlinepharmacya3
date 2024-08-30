package com.jsp.onlinepharmacya3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacya3.dao.MedicalStoreDao;
import com.jsp.onlinepharmacya3.dao.MedicineDao;
import com.jsp.onlinepharmacya3.dto.MedicalStore;
import com.jsp.onlinepharmacya3.dto.Medicines;
import com.jsp.onlinepharmacya3.exception.MedicalStoreIdNotFoundException;
import com.jsp.onlinepharmacya3.exception.MedicineIdNotFOundException;
import com.jsp.onlinepharmacya3.exception.MedicineNameNotFoundException;
import com.jsp.onlinepharmacya3.util.ResponseStructure;

@Service
public class MedicineService {

	@Autowired
	private MedicineDao dao;
	
	@Autowired
	private MedicalStoreDao  storeDao;

	public ResponseEntity<ResponseStructure<Medicines>> addMedicines(int storeId, Medicines medicines) {
		MedicalStore dbMedicalStore=storeDao.findMedicalStore(storeId);
		if(dbMedicalStore!=null) {
//			medicalStore is present so you can add medicines to that store
		medicines.setMedicalStore(dbMedicalStore);
		Medicines dbMedicines=dao.saveMedicines(medicines);
		ResponseStructure<Medicines> structure=new ResponseStructure<>();
		structure.setMessage("Medicines added successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbMedicines);
		return new ResponseEntity<ResponseStructure<Medicines>>(structure,HttpStatus.CREATED);
		
		}else {
			throw new MedicalStoreIdNotFoundException("Sorry failed to add Medicines");
		}
	}

	public ResponseEntity<ResponseStructure<Medicines>> updateMedicine(int medicineId, Medicines medicines) {
		Medicines dbMedicines=dao.updateMedicine(medicineId,medicines);
		if(dbMedicines!=null) {
//			data updated successfully
			ResponseStructure<Medicines> structure=new ResponseStructure<>();
			structure.setMessage("Medicines updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbMedicines);
			return new ResponseEntity<ResponseStructure<Medicines>>(structure,HttpStatus.OK);
		}else {
			throw new MedicineIdNotFOundException("Sorry failed to update Medicines");
		}
	}

	public ResponseEntity<ResponseStructure<Medicines>> deleteMedicine(int medicineId) {
		Medicines dbMedicines=dao.deleteMedicineById(medicineId);
		if(dbMedicines!=null) {
//			data deleted successfully
			ResponseStructure<Medicines> structure=new ResponseStructure<>();
			structure.setMessage("Medicines Deleted successfully");
			structure.setHttpStatus(HttpStatus.FORBIDDEN.value());
			structure.setData(dbMedicines);
			return new ResponseEntity<ResponseStructure<Medicines>>(structure,HttpStatus.FORBIDDEN);
		}else {
			throw new MedicineIdNotFOundException("Sorry failed to delete Medicines");
		}
	}

	public ResponseEntity<ResponseStructure<Medicines>> findMedicine(int medicineId) {
		Medicines dbMedicines=dao.findMedicineById(medicineId);
		if(dbMedicines!=null) {
//			data deleted successfully
			ResponseStructure<Medicines> structure=new ResponseStructure<>();
			structure.setMessage("Medicines fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbMedicines);
			return new ResponseEntity<ResponseStructure<Medicines>>(structure,HttpStatus.FOUND);
		}else {
			throw new MedicineIdNotFOundException("Sorry failed to fetch Medicines");
		}
	}

	public ResponseEntity<ResponseStructure<Medicines>> findMedicineByName(String medicineName) {
		Medicines dbMedicines=dao.findMedicineByName(medicineName);
		if(dbMedicines!=null) {
//			medicine is present with that name
			ResponseStructure<Medicines> structure=new ResponseStructure<>();
			structure.setMessage("Medicines fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbMedicines);
			return new ResponseEntity<ResponseStructure<Medicines>>(structure,HttpStatus.FOUND);
		}else {
//			medicinenot found by that name
			throw new MedicineNameNotFoundException("Sorry failed to fetch the medicine by name");
		}
	}
	
	
}
