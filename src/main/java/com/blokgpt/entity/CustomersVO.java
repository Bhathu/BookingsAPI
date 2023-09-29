package com.blokgpt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "customers")
@Getter
@Setter
public class CustomersVO {

	@Id
	@Column(name="customer_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int customerId;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="address_line1")
	private String addressLine1;
	
	@Column(name="address_line2")
	private String addressLine2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="postalcode")
	private String postalcode;
	
	@Column(name="state")
	private String state;
	
}
