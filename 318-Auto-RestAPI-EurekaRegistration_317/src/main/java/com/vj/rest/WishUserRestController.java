package com.vj.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishUserRestController {

	@GetMapping(value = { "wish/{name}" })
	public ResponseEntity<String> wishMe(@PathVariable("name") String username) {
		String msg = "Have a great future ahead " + username + ".";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

}
