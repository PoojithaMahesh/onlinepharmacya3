package com.jsp.onlinepharmacya3.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MedicalStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeId;
	private String name;
	private String managerName;
	private long phone;
	@ManyToOne
	private Admin admin;
	@OneToOne(mappedBy = "medicalStore")
	private Address address;
	
}
