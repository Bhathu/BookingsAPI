package com.blokgpt.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.blokgpt.dao.CustomersDAO;
import com.blokgpt.entity.CustomersVO;
import com.blokgpt.model.CustomersBO;
import com.blokgpt.service.CustomersService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomersServiceImpl implements CustomersService {
	
	@Autowired
	private CustomersDAO customersDAO;

	@Override
	public CustomersBO saveCustomer(CustomersBO customer) {
		ObjectMapper mapper = new ObjectMapper();
		CustomersVO customersVO = mapper.convertValue(customer, CustomersVO.class);
		
		customersDAO.saveAndFlush(customersVO);
		
		return customer;
	}

	@Override
	public Optional<CustomersBO> fetchCustomer(@NonNull int id) {
		ObjectMapper mapper = new ObjectMapper();
		CustomersVO customersVO = this.customersDAO.findById(String.valueOf(id)).get();
		
		return Optional.of(mapper.convertValue(customersVO, CustomersBO.class));
		
	}

	@Override
	public List<CustomersBO> fetchAllCustomers() {
		ObjectMapper mapper = new ObjectMapper();
		List<CustomersBO> customersBOList = new ArrayList<CustomersBO>();
		
		List<CustomersVO> customersVOList = this.customersDAO.findAll();
		
		customersVOList.stream().forEach(c -> customersBOList.add(mapper.convertValue(c, CustomersBO.class)));
		return customersBOList;
	}

}
