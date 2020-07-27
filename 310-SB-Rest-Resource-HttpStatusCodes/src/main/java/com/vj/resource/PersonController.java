package com.vj.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vj.response.Person;

@RestController
public class PersonController {

	/**
	 * 
	-> When client sends http request to server, it will process that request and it will send response back to client with status code, status message, headers & response body
	
	
	status-code   status-msg   protocol-version
	
	-> HTTP status codes are divided into 5 categories
	
	1xx (100-199) : Information
	
	2xx (200-299) : Success
	
	3xx (300-399) : Redirectional
	
	4xx (400-499) : Client Error
	
	5xx (500-599) : Server Error
	
	
	-> 200 OK
	
	-> 201 Created
	
	-> 204 NO CONTENT
	
	-> 400 BAD Request
	
	-> 404 Not Found
	
	-> 405 Method Not Allowed
	
	-> 406 Not Acceptable
	
	-> 415 Unsupported Media Type
	
	-> 500 Internal Server Error
	 * @param pid
	 * @return
	 */
	@GetMapping(value = { "/person/{pid}" })
	public ResponseEntity<Person> getPersonDetails(@PathVariable("pid") Integer pid) {
		Person p1 = new Person();
		p1.setPId(101);
		p1.setPName("Ajay");
		p1.setPAge("25");
		p1.setPGender("Male");

		Person p2 = new Person();
		p2.setPId(102);
		p2.setPName("Vijay");
		p2.setPAge("26");
		p2.setPGender("Male");

		Person p3 = new Person();
		p3.setPId(103);
		p3.setPName("Priya");
		p3.setPAge("23");
		p3.setPGender("Female");

		if (pid == 101)
			return new ResponseEntity<Person>(p1, HttpStatus.CREATED);
		else if (pid == 102)
			return new ResponseEntity<Person>(p2, HttpStatus.CREATED);
		else if (pid == 103)
			return new ResponseEntity<Person>(p3, HttpStatus.CREATED);
		else
			return new ResponseEntity<Person>(HttpStatus.BAD_REQUEST);
	}

}
