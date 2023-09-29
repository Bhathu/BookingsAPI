package com.blokgpt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.blokgpt.model.CustomersBO;
import com.blokgpt.service.CustomersService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name="Customers", description = "Customers management APIs")
public class CustomersController {
	
	@Autowired
	private CustomersService customersService;
	
	@Operation(
			summary = "Add a new customer to BlokGPT Database",
			description = "Provide the customer details in JSON format to add it to BlokGPT DB",
			tags = {"save"})
	@ApiResponses({
	      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CustomersBO.class), mediaType = "application/json") }),
	      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping("/customers/add")
	public ResponseEntity<Object> addCustomer(@RequestBody CustomersBO customer) {
		try {
			CustomersBO customerBO = this.customersService.saveCustomer(customer);
		} catch(Exception e) {
			return  ResponseEntity.status(500).body(e.getMessage());
		}
		return  ResponseEntity.ok().body("Court added successfully");
	}
	
	
	@Operation(
			summary = "Get all customers from BlokGPT Database",
			description = "Get all the customer details in JSON format from BlokGPT DB",
			tags = {"getAll"})
	@ApiResponses({
	      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CustomersBO.class), mediaType = "application/json") }),
	      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/customers/fetch")
	public ResponseEntity<Object> getAllCustomers() {
		try {
			List<CustomersBO> customerBOList = this.customersService.fetchAllCustomers();
			return  ResponseEntity.ok().body(customerBOList);
		} catch(Exception e) {
			return  ResponseEntity.status(500).body(e.getMessage());
		}
		
	}
	
	
	@Operation(
			summary = "Get customer for the provided id from BlokGPT Database",
			description = "Get the customer details in JSON format for the provided id from BlokGPT DB",
			tags = {"getOne"})
	@ApiResponses({
	      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CustomersBO.class), mediaType = "application/json") }),
	      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/customers/fetch/{id}")
	public ResponseEntity<Object> getCustomerById(@PathVariable("id") Integer id) {
		try {
			CustomersBO customerBO = this.customersService.fetchCustomer(id).get();
			return  ResponseEntity.ok().body(customerBO);
		} catch(Exception e) {
			return  ResponseEntity.status(500).body(e.getMessage());
		}
		
	}

}
