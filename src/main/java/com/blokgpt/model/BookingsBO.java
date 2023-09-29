package com.blokgpt.model;

import java.sql.Date;
import java.sql.Time;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingsBO {

	private int bookingId;
	private int courtId;
	private int customerId;
	private Date playDate;
	private Time startTime;
	private Time endTime;
}
