package com.blokgpt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blokgpt.entity.BookingsVO;

@Repository
public interface BookingsDAO extends JpaRepository<BookingsVO, String>{
	
	@Query(nativeQuery = true,
			value = "select * from bookings where court_id = :courtId")
	public List<BookingsVO> getBookingsByCourtId(@Param("courtId") Integer courtId);
	
	@Query(nativeQuery = true,
			value = "select * from bookings where customer_id = :customerId")
	public List<BookingsVO> getBookingsByCustomerId(@Param("customerId") Integer customerId);
	

}
