package com.jsp.onlinepharmacya3.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.onlinepharmacya3.dto.Medicines;
import com.jsp.onlinepharmacya3.repository.MedicineRepo;

@Repository
public class MedicineDao {

	@Autowired
	private MedicineRepo repo;

	public Medicines saveMedicines(Medicines medicines) {
		return repo.save(medicines);
	}

	public Medicines updateMedicine(int medicineId, Medicines medicines) {
		Optional<Medicines>  optional=repo.findById(medicineId);
		if(optional.isPresent()) {
			medicines.setMedicineId(medicineId);
			medicines.setMedicalStore(optional.get().getMedicalStore());
			return repo.save(medicines);	
		}return null;
	}

	public Medicines deleteMedicineById(int medicineId) {
		Optional<Medicines>  optional=repo.findById(medicineId);
		if(optional.isPresent()) {
			repo.deleteById(medicineId);
			return optional.get();	
		}return null;
	}

	public Medicines findMedicineById(int medicineId) {
		Optional<Medicines>  optional=repo.findById(medicineId);
		if(optional.isPresent()) {
			return optional.get();	
		}return null;
	}

	public Medicines findMedicineByName(String medicineName) {
		Optional<Medicines> optional=repo.findMedicineByName(medicineName);
		if(optional.isPresent()) {
//			medicine is present with that name;
			return optional.get();
		}return null;
	}
	
}
