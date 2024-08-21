package com.jsp.onlinepharmacya3.exception;

import lombok.Getter;

@Getter
public class AdminPhoneNumberNotValidException extends RuntimeException {

	private String message;

	public AdminPhoneNumberNotValidException(String message) {
		super();
		this.message = message;
	}
	
	
}
