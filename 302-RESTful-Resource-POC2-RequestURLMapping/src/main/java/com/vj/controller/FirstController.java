package com.vj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/c1")
public class FirstController {

	//http://localhost:2525/c1/
	@GetMapping("/")
	public String defaultMsg() {
		return "Default msg from Controller1";
	}
	//http://localhost:2525/c1/welcome
	@GetMapping(value= {"/welcome"})
	public String welcomeMsg() {
		return "Welcome to Srping REST - Controller1";
	}
	
	//http://localhost:2525/c1/bye
	@GetMapping("/bye") 
	public String messageTwo() {
		return "Goodbyee - controller1";
	}
}

/**
 * Notes : 
 * 
 * 
-> We can develop REST API using Spring with REST

-> Spring With REST is part of Spring Web MVC

-> If we add Spring Web MVC Jars then we can develop REST API

-> To Develop REST API in Spring Boot Project we need to add spring-boot-starter-web in pom.xml file.

-> To develop REST component we will use below annotation

	@RestController

Note: This annotation is available from Spring version 4.o

-> Before @Restcontroller annotation people used to work with @Controller + @ResponseBody.

-> Rest Controller methods we have to bind with Http Protocol methods.

-> To bind our methods to HTTP protocol method we will use below annotations

	@GetMapping
	@PostMapping
	@PutMapping
	@DeleteMapping

-> RestController methods will return Raw Response in Response Body.

-> To check apps in google we can use below URL

	chrome://apps/

What is Rest Resource
----------------------
REST Resource is a distributed component which provides business services to other applications over a network.

What is Rest Client
-------------------
Rest Client can be a human, can be a device, can be an application and can be a tool...

Anybody/anything which is capable of sending Http request can be treated as Rest Client.


-> In RestController, If we have more than one method binded same HTTP Request method then we should unique urls for both methods

-> If we have more than one RestController in Project, it is higly recommended to specify class level URL pattern.

@RestController
@RequestMapping(value="/demo")
public class DemoController {

}

Note: Writing class level url-pattern is optional

-> Writing method level url pattern is optional if we have only one method which is binded to particular Http request method.

-> If we have more than one method binded to particular HTTP Request then we should choose unique url pattern for all methods.


Note: It is recommended to write both class level and method level url patterns so that we can avoid ambiguity problems in url-patterns.

 * */
