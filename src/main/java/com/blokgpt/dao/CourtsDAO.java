package com.blokgpt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blokgpt.entity.CourtsVO;

@Repository
public interface CourtsDAO extends JpaRepository<CourtsVO, String> {

	@Query(nativeQuery = true,
			value = "select CONCAT(address_line1, ' ' , address_line2, ' ', city, ' ' , state, ' ', postalCode) from Courts where court_name = :courtName")
	public List<String> getAddressOfCourt(@Param("courtName") String courtName);
	
	@Query(nativeQuery = true,
			value = "select * from Courts where CONCAT(address_line1, ' ' , address_line2, ' ', city, ' ' , state, ' ', postalCode) like :location")
	public List<CourtsVO> getCourtsInALocation(@Param("location") String location);
}
