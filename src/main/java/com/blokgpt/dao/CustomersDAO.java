package com.blokgpt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blokgpt.entity.CustomersVO;

@Repository
public interface CustomersDAO extends JpaRepository<CustomersVO, String>{

}
