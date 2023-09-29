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

import com.blokgpt.model.CourtsBO;
import com.blokgpt.service.CourtsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Courts", description = "Courts management APIs")
@Controller
public class CourtsController {
	
	@Autowired
	private CourtsService courtsService;
	
	@Operation(
			summary = "Add a new court/venue to BlokGPT Database",
			description = "Provide the court details in JSON format to add it to BlokGPT DB",
			tags = {"save"})
	@ApiResponses({
	      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CourtsBO.class), mediaType = "application/json") }),
	      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping("/courts/add")
	public ResponseEntity<String> addCourts(@RequestBody CourtsBO court) {
		try {
			CourtsBO addedCourt = this.courtsService.save(court);
		} catch(Exception e) {
			return  ResponseEntity.status(500).body(e.getMessage());
		}
		return  ResponseEntity.ok().body("Court added successfully");
	}
	

	@Operation(
			summary = "Get list of all the courts available in BlokGPT DB",
			description = "Provides the list of all the courts availble in BlokGPT DB when no paramateres are provided",
			tags = {"fetchAll"})
	@ApiResponses({
	      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CourtsBO.class), mediaType = "application/json") }),
	      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/courts/fetch")
	public ResponseEntity<Object> getAllCourts() {
		try {
			List<CourtsBO> courtsList = this.courtsService.getAllCourts();
			return ResponseEntity.ok(courtsList);
		} catch(Exception e) {
			return  ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	
	
	@Operation(
			summary = "Get the address of a particular court name passed in the request",
			description = "Get the address of the court name provided in the req available in BlokGPT Database",
			tags = {"get", "address"})
	@ApiResponses({
	      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
	      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/courts/address")
	public ResponseEntity<Object> getAddress(@RequestParam(name = "courtName") String courtName) {
		try {
			List<String> courtsList = this.courtsService.getAddressOfCourt(courtName);
			return ResponseEntity.ok(courtsList);
		} catch(Exception e) {
			return  ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	
	@Operation(
			summary = "Get all the courts in a particular location",
			description = "Get all the courts from the provided location available in BlokGPT Database",
			tags = {"get", "address"})
	@ApiResponses({
	      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CourtsBO.class), mediaType = "application/json") }),
	      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/courts/fetch/location")
	public ResponseEntity<Object> getCourtsInALocation(@RequestParam(name = "location") String location) {
		try {
			List<CourtsBO> courtsList = this.courtsService.getCourtsInALocation(location);
			return ResponseEntity.ok(courtsList);
		} catch(Exception e) {
			return  ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	
	
	@Operation(
			summary = "Get the Court based on id",
			description = "Get court for the provided id available in BlokGPT Database",
			tags = {"get", "court", "id"})
	@ApiResponses({
	      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CourtsBO.class), mediaType = "application/json") }),
	      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/courts/fetch/{id}")
	public ResponseEntity<Object> getCourtsById(@PathVariable("id") Integer id) {
		try {
			CourtsBO court = this.courtsService.getCourtsById(id).get();
			return ResponseEntity.ok(court);
		} catch(Exception e) {
			return  ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
}
