package com.jsp.onlinepharmacya3.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressIdNotFoundException extends RuntimeException {

	private String message;
	
}
