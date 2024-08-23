package com.jsp.onlinepharmacya3.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MedicalStoreIdNotFoundException extends RuntimeException {

	private String message;
}
