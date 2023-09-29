package com.blokgpt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.blokgpt.model.BookingsBO;

public interface BookingsService {

	
	public BookingsBO save(BookingsBO bookingsBO);
	
	public List<BookingsBO> fetchAll();
	
	public Optional<BookingsBO> fetchById(@NonNull Integer id);
	
	public List<BookingsBO> fetchBookingsByCourtId(@NonNull Integer courtId);
	
	public List<BookingsBO> fetchBookingsByCustomerId(@NonNull Integer customerId);
}
