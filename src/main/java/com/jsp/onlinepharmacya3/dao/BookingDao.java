package com.jsp.onlinepharmacya3.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.onlinepharmacya3.dto.Bookings;
import com.jsp.onlinepharmacya3.repository.BookingRepo;

@Repository
public class BookingDao {

	@Autowired
	private BookingRepo repo;

	public Bookings saveBookings(Bookings bookings) {
		return repo.save(bookings);
	}
	
	
}
