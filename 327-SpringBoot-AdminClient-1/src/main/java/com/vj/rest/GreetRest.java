package com.vj.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRest {

	@GetMapping(value = "/greet")
	public String greetMe() {
		return "Hello";
	}
	
}
