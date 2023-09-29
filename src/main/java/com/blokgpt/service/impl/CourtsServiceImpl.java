package com.blokgpt.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blokgpt.dao.CourtsDAO;
import com.blokgpt.entity.CourtsVO;
import com.blokgpt.model.CourtsBO;
import com.blokgpt.service.CourtsService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NonNull;

@Service
public class CourtsServiceImpl implements CourtsService {

	@Autowired
	private CourtsDAO courtsDAO;

	@Override
	public List<CourtsBO> getAllCourts() {
		List<CourtsBO> courtsList = new ArrayList<CourtsBO>();
		List<CourtsVO> courtsVOList = courtsDAO.findAll();
		ObjectMapper mapper = new ObjectMapper();

		courtsVOList.stream().forEach(court -> courtsList.add(mapper.convertValue(court, CourtsBO.class)));

		return courtsList;
	}

	@Override
	public Optional<CourtsBO> getCourtsById(@NonNull Integer id) {
		ObjectMapper mapper = new ObjectMapper();
		CourtsVO courtsVO = courtsDAO.findById(String.valueOf(id)).get();

		return Optional.of(mapper.convertValue(courtsVO, CourtsBO.class));

	}

	@Override
	public CourtsBO save(CourtsBO court) {
		ObjectMapper mapper = new ObjectMapper();
		CourtsVO courtsVO = mapper.convertValue(court, CourtsVO.class);

		courtsDAO.saveAndFlush(courtsVO);
		court.setCourtId(courtsVO.getCourtId());
		return court;
	}

	@Override
	public List<String> getAddressOfCourt(String courtName) {
		return this.courtsDAO.getAddressOfCourt(courtName);
	}

	@Override
	public List<CourtsBO> getCourtsInALocation(@NonNull String location) {
		location = "%" + location + "%";
		List<CourtsVO> cousrtsVOList = this.courtsDAO.getCourtsInALocation(location);

		List<CourtsBO> courtsList = new ArrayList<CourtsBO>();
		ObjectMapper mapper = new ObjectMapper();

		cousrtsVOList.stream().forEach(court -> courtsList.add(mapper.convertValue(court, CourtsBO.class)));

		return courtsList;

	}

}
