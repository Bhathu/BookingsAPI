package com.blokgpt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import com.blokgpt.model.CourtsBO;

public interface CourtsService {
	
	public List<CourtsBO> getAllCourts();
	
	public Optional<CourtsBO> getCourtsById(@NonNull Integer id);
	
	public CourtsBO save(CourtsBO court);
	
	public List<String> getAddressOfCourt(String courtName);
	
	public List<CourtsBO> getCourtsInALocation(String location);
}
