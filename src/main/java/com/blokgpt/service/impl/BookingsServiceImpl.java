package com.blokgpt.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.blokgpt.dao.BookingsDAO;
import com.blokgpt.entity.BookingsVO;
import com.blokgpt.model.BookingsBO;
import com.blokgpt.service.BookingsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BookingsServiceImpl implements BookingsService{

	@Autowired
	private BookingsDAO bookingsDAO;
	
	@Override
	public BookingsBO save(BookingsBO bookingsBO) {
		ObjectMapper mapper = new ObjectMapper();
		BookingsVO bookingsVO = mapper.convertValue(bookingsBO, BookingsVO.class);
		
		bookingsVO = this.bookingsDAO.save(bookingsVO);
		
		bookingsBO.setBookingId(bookingsVO.getBookingId());
		
		return bookingsBO;
	}

	@Override
	public List<BookingsBO> fetchAll() {
		ObjectMapper mapper = new ObjectMapper();
		List<BookingsBO> bookingsBOList = new ArrayList<BookingsBO>();
		
		List<BookingsVO> bookingsVOList = this.bookingsDAO.findAll();
		
		bookingsVOList.stream().forEach(b -> bookingsBOList.add(mapper.convertValue(b, BookingsBO.class)));
		return bookingsBOList;
	}

	@Override
	public Optional<BookingsBO> fetchById(@NonNull Integer id) {
		ObjectMapper mapper = new ObjectMapper();
		
		BookingsVO bookingsVO = this.bookingsDAO.findById(String.valueOf(id)).get();
		
		return Optional.of(mapper.convertValue(bookingsVO, BookingsBO.class));
	}

	@Override
	public List<BookingsBO> fetchBookingsByCourtId(Integer courtId) {
		ObjectMapper mapper = new ObjectMapper();
		List<BookingsBO> bookingsBOList = new ArrayList<BookingsBO>();
		
		List<BookingsVO> bookingsVOList = this.bookingsDAO.getBookingsByCourtId(courtId);
		
		bookingsVOList.stream().forEach(b -> bookingsBOList.add(mapper.convertValue(b, BookingsBO.class)));
		return bookingsBOList;
	}

	@Override
	public List<BookingsBO> fetchBookingsByCustomerId(Integer customerId) {
		ObjectMapper mapper = new ObjectMapper();
		List<BookingsBO> bookingsBOList = new ArrayList<BookingsBO>();
		
		List<BookingsVO> bookingsVOList = this.bookingsDAO.getBookingsByCustomerId(customerId);
		
		bookingsVOList.stream().forEach(b -> bookingsBOList.add(mapper.convertValue(b, BookingsBO.class)));
		return bookingsBOList;
	}

}
