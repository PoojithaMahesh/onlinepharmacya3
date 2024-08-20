package com.jsp.onlinepharmacya3.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class AdminEmailNotValidException extends RuntimeException {

	private String message;

	public AdminEmailNotValidException(String message) {
		super();
		this.message = message;
	}

	
	
	
}
