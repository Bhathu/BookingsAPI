package com.blokgpt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.blokgpt.model.CustomersBO;

public interface CustomersService {

	public CustomersBO saveCustomer(CustomersBO customer);
	
	public Optional<CustomersBO> fetchCustomer(@NonNull int id);
	
	public List<CustomersBO> fetchAllCustomers();
}
