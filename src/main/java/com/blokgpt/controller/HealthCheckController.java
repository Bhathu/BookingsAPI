package com.blokgpt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="HealthCheck", description = "BlokGPT health check APIs")
@Controller
public class HealthCheckController {

	

	@Operation(
			summary = "Health check API",
			description = "This API provides update on application health check",
			tags = {"healthCheck"})
	@ApiResponses({
	      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class)) }),
	      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/healthCheck")
	public ResponseEntity<String> healthCheck() {
		return  ResponseEntity.ok().body("Application up & running!!");
	}
}
