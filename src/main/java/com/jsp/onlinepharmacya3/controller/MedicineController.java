package com.jsp.onlinepharmacya3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.onlinepharmacya3.dto.Medicines;
import com.jsp.onlinepharmacya3.service.MedicineService;
import com.jsp.onlinepharmacya3.util.ResponseStructure;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

	@Autowired
	private MedicineService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Medicines>> addMedicineToTheMedicalStore(@RequestParam int storeId,
			@RequestBody Medicines  medicines){
		return service.addMedicines(storeId,medicines);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Medicines>> updateMedicines(@RequestParam int medicineId,
			@RequestBody Medicines medicines){
		return service.updateMedicine(medicineId,medicines);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Medicines>> deleteMedicines(@RequestParam int medicineId){
		return service.deleteMedicine(medicineId);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Medicines>> findMedicines(@RequestParam int medicineId){
		return service.findMedicine(medicineId);
	}
	@GetMapping("/findbyname")
	public ResponseEntity<ResponseStructure<Medicines>> findMedicinesByName(@RequestParam String medicineName){
		return service.findMedicineByName(medicineName);
	}
}
