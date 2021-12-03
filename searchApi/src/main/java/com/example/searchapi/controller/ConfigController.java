package com.example.searchapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {

	@Value("${spring.message}")
	private String message;

	@GetMapping("/config")
	public String message () {
		return message;
	}

}
