package com.jsp.onlinepharmacya3.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.onlinepharmacya3.dao.BookingDao;
import com.jsp.onlinepharmacya3.dao.CustomerDao;
import com.jsp.onlinepharmacya3.dao.MedicineDao;
import com.jsp.onlinepharmacya3.dto.Bookings;
import com.jsp.onlinepharmacya3.dto.Customer;
import com.jsp.onlinepharmacya3.dto.Medicines;
import com.jsp.onlinepharmacya3.enums.BookingStatus;
import com.jsp.onlinepharmacya3.exception.BookingCantCancelledException;
import com.jsp.onlinepharmacya3.exception.BookingIdNotFoundException;
import com.jsp.onlinepharmacya3.exception.CustomeridNotFoundException;
import com.jsp.onlinepharmacya3.exception.MedicineIdNotFOundException;
import com.jsp.onlinepharmacya3.util.ResponseStructure;

@Service
public class BookingService {

	@Autowired
	private BookingDao dao;
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private MedicineDao medicineDao;

	public ResponseEntity<ResponseStructure<Bookings>> saveBooking(int medicineId, int customerId, Bookings bookings) {
		Customer dbCustomer=customerDao.findCustomer(customerId);
		if(dbCustomer!=null) {
			Medicines dbMedicines=medicineDao.findMedicineById(medicineId);
			if(dbMedicines!=null) {
//				medicine is present and customer is present
				bookings.setOrderDate(LocalDate.now());
				LocalDate expectedDate=LocalDate.now().plusDays(7);
				bookings.setExpectedDate(expectedDate);
				
				bookings.setBookingStatus(BookingStatus.ACTIVE);
				List<Medicines> medicines=new ArrayList<Medicines>();
				medicines.add(dbMedicines);
				bookings.setMedicines(medicines);
				
				bookings.setCustomer(dbCustomer);
				List<Bookings> bookingsofcustomer=new ArrayList<Bookings>();
				bookingsofcustomer.add(bookings);
				dbCustomer.setBookings(bookingsofcustomer);
				Bookings dbBookings=dao.saveBookings(bookings);
				ResponseStructure<Bookings> structure=new ResponseStructure<Bookings>();
				structure.setMessage("BOOKING SUCCESSFULLY");
				structure.setHttpStatus(HttpStatus.CREATED.value());
				structure.setData(dbBookings);
				return new ResponseEntity<ResponseStructure<Bookings>>(structure,HttpStatus.CREATED);				
			}else {
				throw new MedicineIdNotFOundException("Sorry failed to add bookings");
			}
		}else {
			throw new CustomeridNotFoundException("Sorry failed to add bookings");
		}
	}

	public ResponseEntity<ResponseStructure<Bookings>> cancelBooking(int bookingId) {
//		first im going to find this booking
		Bookings dbBookings=dao.findBookingById(bookingId);
		if(dbBookings!=null) {
//			dbooking id is present
			LocalDate cantcancelledDate=dbBookings.getExpectedDate().minusDays(2);
			if(dbBookings.getBookingStatus().equals(BookingStatus.DELIVERED)) {
//				it is alreadydelivered how to cancel ???
				throw new BookingCantCancelledException("Sorry Booking Already Delivered");
			}else if(dbBookings.getBookingStatus().equals(BookingStatus.CANCELLED)) {
				throw new BookingCantCancelledException("Sorry Booking Already Cancelled");
			}else if(LocalDate.now().equals(cantcancelledDate)&&LocalDate.now().isAfter(cantcancelledDate) ) {
				throw new BookingCantCancelledException("Sorry Its Already a Date");
			}else {
//				Now everything is fine i can cancel this booking
				dbBookings.setBookingStatus(BookingStatus.CANCELLED);
				ResponseStructure<Bookings> structure=new ResponseStructure<>();
				structure.setMessage("Booking Cancelled successfully");
				structure.setHttpStatus(HttpStatus.FORBIDDEN.value());
				structure.setData(dbBookings);
				return new ResponseEntity<ResponseStructure<Bookings>>(structure,HttpStatus.FORBIDDEN);
			}
		}else {
//			booking is not present how to cancel
			throw new BookingIdNotFoundException("Sorry failed to cancelBooking");
		}
		
		
		
		
	}
	
}
