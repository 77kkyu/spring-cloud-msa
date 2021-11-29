package com.example.board.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequestMapping("/v1/board")
@RefreshScope
@RestController
public class BoardController {

	@Value("${spring.message}")
	private String message;

	@Value("${server.port}")
	private int port;

	@GetMapping("/config")
	public String configInfo() {
		String configInfo = "Board Service Message : "+message+"  /   port : " + port;
		log.info(configInfo);
		return configInfo;
	}



}
