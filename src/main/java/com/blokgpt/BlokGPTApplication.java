package com.blokgpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableJpaRepositories("com.blokgpt.*")
@EntityScan("com.blokgpt.entity")
@ComponentScan("com.blokgpt.*")
@OpenAPIDefinition(info = @Info(title = "BlokGPT API", version = "1.0", description = "ChatBot for Bloking courts or to create new court"))
public class BlokGPTApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlokGPTApplication.class, args);
	}

}
