package com.blokgpt.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Courts")
public class CourtsVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="court_id")
	private int courtId;
	
	@Column(name="court_name")
	private String courtName;
	
	@Column(name="address_line1")
	private String addressLine1;
	
	@Column(name="address_line2")
	private String AddressLine2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="postalcode")
	private String postalCode;
	
	@Column(name="state")
	private String state;
}
