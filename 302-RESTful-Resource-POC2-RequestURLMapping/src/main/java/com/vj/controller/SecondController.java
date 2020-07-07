package com.vj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/c2")
public class SecondController {

	@GetMapping("/")
	public String defaultCountry() {
		return "Welcome to India - Controller2";
	}
	
//	@GetMapping(value= {"/","/russia"})		//EXCEPTION : Ambiguous handler methods mapped ("/")
	@GetMapping(value= {"/russia"})		//url name is case sensitive
	public String countryOne() {
		return "Welcome to Russia- Controller 2";
	}
	
	@GetMapping("/usa")
	public String countryTwo() {
		return "Welcome to USA - Controller 2";
	}
}
