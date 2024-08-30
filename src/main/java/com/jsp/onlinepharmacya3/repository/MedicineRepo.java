package com.jsp.onlinepharmacya3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.onlinepharmacya3.dto.Medicines;

public interface MedicineRepo extends JpaRepository<Medicines, Integer>{
    @Query("select m from Medicine m where m.medicineName=?1")
	Optional<Medicines> findMedicineByName(String medicineName);

}
