package com.example.common.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/common")
@RefreshScope
@RestController
public class CommonController {

	@Value("${spring.message}")
	private String message;

	@Value("${server.port}")
	private int port;

	@Value("${spring.secretkey}")
	private String secretkey;

	@GetMapping("/config")
	public String configInfo() {
		String configInfo = "Common Service Message : "+message+"  /   port : "+port+"   /   secretKey : "+secretkey;
		return configInfo;
	}

}
