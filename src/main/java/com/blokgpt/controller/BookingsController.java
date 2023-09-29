package com.blokgpt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.blokgpt.model.BookingsBO;
import com.blokgpt.service.BookingsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Bookings", description = "Bookings management APIs")
@Controller
public class BookingsController {
	
	@Autowired
	private BookingsService bookingsService;
	
	@Operation(
			summary = "Add a new bookings to BlokGPT Database",
			description = "Add new court bookings in JSON format to BlokGPT DB",
			tags = {"save"})
	@ApiResponses({
	      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = BookingsBO.class), mediaType = "application/json") }),
	      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping("/bookings/add")
	public ResponseEntity<Object> addBookings(@RequestBody BookingsBO bookings) {
		try {
			BookingsBO bookingsBO = this.bookingsService.save(bookings);
		} catch(Exception e) {
			return  ResponseEntity.status(500).body(e.getMessage());
		}
		return  ResponseEntity.ok().body("Court added successfully");
	}
	
	
	@Operation(
			summary = "Get all bookings from BlokGPT Database",
			description = "Get all the bookings details in JSON format from BlokGPT DB",
			tags = {"getAll"})
	@ApiResponses({
	      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = BookingsBO.class), mediaType = "application/json") }),
	      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/bookings/fetch")
	public ResponseEntity<Object> getAllBookings() {
		try {
			List<BookingsBO> bookingsBOList = this.bookingsService.fetchAll();
			return  ResponseEntity.ok().body(bookingsBOList);
		} catch(Exception e) {
			return  ResponseEntity.status(500).body(e.getMessage());
		}
		
	}
	
	
	@Operation(
			summary = "Get bookings for the provided id from BlokGPT Database",
			description = "Get the booking details in JSON format for the provided id from BlokGPT DB",
			tags = {"getOne"})
	@ApiResponses({
	      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = BookingsBO.class), mediaType = "application/json") }),
	      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/bookings/fetch/{id}")
	public ResponseEntity<Object> getBookingsById(@PathVariable("id") Integer id) {
		try {
			BookingsBO bookingsBO = this.bookingsService.fetchById(id).get();
			return  ResponseEntity.ok().body(bookingsBO);
		} catch(Exception e) {
			return  ResponseEntity.status(500).body(e.getMessage());
		}
		
	}
	
	
	@Operation(
			summary = "Get all the bookings for the provided court id from BlokGPT Database",
			description = "Get all the booking details in JSON format for the provided court id from BlokGPT DB",
			tags = {"getBookingsByCourtId", "Bookings By Court Id"})
	@ApiResponses({
	      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = BookingsBO.class), mediaType = "application/json") }),
	      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/bookings/search/court")
	public ResponseEntity<Object> getBookingsByCourtId(@RequestParam(name = "courtId") Integer courtId) {
		try {
			List<BookingsBO> bookingsBOList = this.bookingsService.fetchBookingsByCourtId(courtId);
			return  ResponseEntity.ok().body(bookingsBOList);
		} catch(Exception e) {
			return  ResponseEntity.status(500).body(e.getMessage());
		}
		
	}
	
	
	@Operation(
			summary = "Get all the bookings for the provided customer id from BlokGPT Database",
			description = "Get all the booking details in JSON format for the provided customer id from BlokGPT DB",
			tags = {"getBookingsByCustomerId" , "Bookings By Customer Id"})
	@ApiResponses({
	      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = BookingsBO.class), mediaType = "application/json") }),
	      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/bookings/search/customer")
	public ResponseEntity<Object> getBookingsByCustomerId(@RequestParam(name = "customerId") Integer customerId) {
		try {
			List<BookingsBO> bookingsBOList = this.bookingsService.fetchBookingsByCustomerId(customerId);
			return  ResponseEntity.ok().body(bookingsBOList);
		} catch(Exception e) {
			return  ResponseEntity.status(500).body(e.getMessage());
		}
		
	}

}
