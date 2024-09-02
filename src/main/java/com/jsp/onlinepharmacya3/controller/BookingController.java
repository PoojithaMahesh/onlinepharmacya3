package com.jsp.onlinepharmacya3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.onlinepharmacya3.dto.Bookings;
import com.jsp.onlinepharmacya3.service.BookingService;
import com.jsp.onlinepharmacya3.util.ResponseStructure;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Bookings>> addBooking(@RequestParam int medicineId,
			@RequestParam int customerId,@RequestBody Bookings bookings){
		return service.saveBooking(medicineId,customerId,bookings);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Bookings>> cancelbooking(@RequestParam int bookingId){
		return service.cancelBooking(bookingId);
	}
}
