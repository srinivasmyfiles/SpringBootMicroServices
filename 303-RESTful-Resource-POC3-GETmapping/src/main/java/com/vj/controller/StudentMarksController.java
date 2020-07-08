package com.vj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marks")
public class StudentMarksController {
 
	/**
	 * 1. In this method resource, default required=true. i.e. Client must 
	 * 		pass value to access the Resource
	 * 2. We can make passing @RequestParam value optional by giving required=false.
	 * 3. We can also give a default value to RequestParam,
	 * 	  it will be used in case of no value given by Client
	 * @param rno
	 * @return
	 */
	@GetMapping("/vijay")
	public String studentOne(
			@RequestParam(value = "rno", 
			required = false, 
			defaultValue = "102"
			) Integer rno) {
		if (rno == 101)
			return " Marks aquired by " + rno + " : 575/600";
		else
			return "Pass a valid Roll Number !";
	}

	/**
	 * 1. In this method resource, client must pass rno RequestParam value, and Subject value is
	 * optional to send.
	 * 2. The required value for rno defalut is true and there is no Default value as well.
	 * 3. Passing subject is optional and defalut will be used.
	 * @param rno
	 * @return
	 */
	@GetMapping("/chandra")
	public String studentTwo(
			@RequestParam("rno") Integer rno,
			@RequestParam(value="sub",required = false,defaultValue = "m1"
			) String subject) {
		if (rno == 105 && subject.equalsIgnoreCase("m1"))
			return " Marks aquired in "+subject+" by " + rno + " : 475/600";
		else
			return " Invalid Roll number !";
	}
}

/**
Today's session : Request Parameters
--------------------------------------------------------
-> To develop Distributed component in Spring MVC/Spring Boot we will  use @RestController annotation

-> If we want to make our method as distributed method we should bind that to Http Request Methods
	
-> To bind our methods to Http Request methods we will use below annotations

		@GetMapping
		@PostMapping
		@PutMapping
		@DeleteMapping

Http GET Request
----------------

When we should bind our method to HTTP GET Request?
---------------------------------------------------
->Based on Client Request, if Resource wants to send data to client then we 
	should bind that method to GET Request method.

-> To bind the method to GET request method we will use @GetMapping annotation

@GetMapping(value="/hi")
public String sayHi(){
   return "Hi, Ashok";
}

Ex:
----
Client wants to get Product Info
Client wants to one employee info
Client wants to get book info

-> HTTP GET method is idempotent method (Safe)

-> Idempotent methods are safe methods, if we send same request for multiple 
	times also they won't change resources(data) at the server

-> For GET Request method Request Body will not be available

How to send data to server in GET Request?
------------------------------------------
To send data in GET Request we can use below things

	1) Query Parameters
	2) Path Parameters

Notes: Query Paramters & Path Parameters will be present in URL.

Query Parameters
-----------------
-> Query Parameters are used to send data from client to server in URL.

-> Query Parameters will represent data in Key-Value pair format

	Ex : ?id=101
	Ex : ?id=101&name=Ashok

Note: Query Parameters should present only at end of the URL.

  REST Endpoint URl :http://www.usa.gov.in/getFpdScores
  Input : SSN Number as Query Parameter (key is ssn)

http://www.usa.gov.in/getFpdScores?ssn=797979799


-> To read Query Parameter in Resource method we will use @RequestParam annotation

Syntax
------
@GetMapping("/hello")
public String sayHello(@RequestParam("name") String name){
		return "Hello, "+name;
}

Query Parameter application
---------------------------
@RestController
@RequestMapping("/fpd")
public class FpdScoresRestController {

	@GetMapping(value="/score")
	public String getFpdScores(@RequestParam("ssn") Long ssn) {
		//logic retrive from db
		return "FPD Score Is : 75";
	}
	
}


REST Endpoint URL : http://localhost:8081/fpd/score?ssn=897878897

	http://localhost:8081/fpd/score

Note: When we are using @RequestParam annotation, Query Parameters are 
	mandatory in URL to access Resource.


-> We can make Query Parameters as Optional using below approach

	@GetMapping(value = "/score")
	public String getFpdScores(
			@RequestParam(
					value = "ssn", 
					required = false, 
					defaultValue = "7797997979") Long ssn) {
		
		System.out.println("SSN :: " + ssn);
		// logic retrive from db
		return "FPD Score Is : 75";
		
	}

-> When we make Query Parameter is optional, we can consider defaultValue like above


*/