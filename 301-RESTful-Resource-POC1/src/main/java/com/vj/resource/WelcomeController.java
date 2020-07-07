package com.vj.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController		//@Controller + @RequestBody = @RestController
public class WelcomeController {

	@GetMapping(value = {"/", "/welcome"})
	public String welcomePage() {
		//we return the RAW Response / DATA, not LVN
		String msg="Welcome to RESTful services";
		return msg;
	}
	
}
