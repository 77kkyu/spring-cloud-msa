package com.example.searchapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/search")
@RefreshScope
@RestController
public class testController {

	@Value("${spring.message}")
	private String message;

	@GetMapping("/message")
	public String search() {
		return "Search Message : " + message;
	}

}
