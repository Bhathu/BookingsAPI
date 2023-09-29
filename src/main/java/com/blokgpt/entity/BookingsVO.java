package com.blokgpt.entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name="bookings")
@Getter
@Setter
public class BookingsVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="booking_id")
	private int bookingId;
	
	@Column(name="court_id")
	private int courtId;
	
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="play_date")
	private Date playDate;
	
	@Column(name="start_time")
	private Time startTime;
	
	@Column(name="end_time")
	private Time endTime;
	
	
	
}
