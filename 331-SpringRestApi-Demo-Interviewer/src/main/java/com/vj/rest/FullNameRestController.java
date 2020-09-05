package com.vj.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FullNameRestController {

	@GetMapping(value = {"myfullname/{fname}/{midname}/{lname}"})
	public ResponseEntity<String> getFullName(
			@PathVariable("fname") String firstName,
			@PathVariable("midname") String middleName,
			@PathVariable("lname") String lastName
			){
		String fullName="Your name is : "+firstName+middleName+lastName;
		return new ResponseEntity<String>(fullName, HttpStatus.OK); 
	}
	
}
