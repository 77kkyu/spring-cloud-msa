package com.example.search.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/search")
@RefreshScope
@RestController
public class SearchController {

	@Value("${spring.message}")
	private String message;

	@Value("${server.port}")
	private int port;

	@GetMapping("/config")
	public String configInfo() {
		String configInfo = "Search Service Message : "+message+"  /   port : " + port;
		return configInfo;
	}

}
