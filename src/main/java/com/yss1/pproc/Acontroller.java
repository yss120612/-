package com.yss1.pproc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Acontroller {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@RequestMapping("/aaa")
	public String index2() {
		return "<!DOCTYPE html><html><body><h1>Yss is genius!</h1></body></html>";
	}
	
}
