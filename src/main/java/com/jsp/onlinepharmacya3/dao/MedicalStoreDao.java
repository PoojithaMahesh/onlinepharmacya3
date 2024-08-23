package com.jsp.onlinepharmacya3.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.onlinepharmacya3.dto.MedicalStore;
import com.jsp.onlinepharmacya3.repository.MedicalStoreRepo;

@Repository
public class MedicalStoreDao {

	@Autowired
	private MedicalStoreRepo repo;

	public MedicalStore saveMedicalStore(MedicalStore medicalStore) {
		// TODO Auto-generated method stub
		return repo.save(medicalStore);
	}

	public MedicalStore updateMedicalStore(int storeId, MedicalStore medicalStore) {
		Optional<MedicalStore> optional=repo.findById(storeId);
		if(optional.isPresent()) {
//			store is presnt then i cam update the data
			medicalStore.setStoreId(storeId);
			medicalStore.setAddress(optional.get().getAddress());
			medicalStore.setAdmin(optional.get().getAdmin());
			return repo.save(medicalStore);
			
		}else {
			return null;
		}
	}

	public MedicalStore findMedicalStore(int storeId) {
		Optional<MedicalStore> optional=repo.findById(storeId);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}

	public MedicalStore deleteMedicalStoreById(int storeId) {
		Optional<MedicalStore> optional=repo.findById(storeId);
		if(optional.isPresent()) {
			repo.deleteById(storeId);
			return optional.get();
		}else {
			return null;
		}
	}
	
}
