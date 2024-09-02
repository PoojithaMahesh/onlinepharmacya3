package com.jsp.onlinepharmacya3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.onlinepharmacya3.dto.Bookings;

public interface BookingRepo extends JpaRepository<Bookings, Integer>{
	

}
