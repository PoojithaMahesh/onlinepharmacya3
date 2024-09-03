package com.jsp.onlinepharmacya3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.onlinepharmacya3.util.ResponseStructure;

@RestControllerAdvice
public class OnlinePharmacyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handlePhoneNumberNotValidException(
			AdminPhoneNumberNotValidException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("INVALID PHONENUMBER");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleEmailNotValidException(
			AdminEmailNotValidException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("INVALID ADMIN EMAIL!!!!!!!!!!!!!");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleAdminPasswordNotValidException(
			AdminPasswordNotValidException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("INVALID ADMIN PASSWORDDDDD!!!!!!!!!");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleAdminIdNotFoundException(
			AdminIdNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Sorry Admin id is not found");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleCustomerIdNotFoundException(
			CustomeridNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Sorry customer id is not found");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleBookingIdNotFoundException(
			BookingIdNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Sorry Booking id is not found");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleCantCancelledException(
			BookingCantCancelledException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Sorry Booking Cant cancelled");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleAddressIdNotFoundException(
			AddressIdNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Sorry Address id is not found");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleStoreIdNotFoundException(
			MedicalStoreIdNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Sorry Store id is not found");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleStaffIdNotFoundException(StaffIdNotFoudException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Sorry Staff id is not found");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleMedicinesIdNotFoundException(
			MedicineIdNotFOundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Sorry Medicine id is not found");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleMedicinesNameNotFoundException(
			MedicineNameNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Sorry Medicine name is not found");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	
}
