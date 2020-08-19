package com.vj.rests;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameAndAgeRestController {
	/**
	 
	-> Service registry is used to register all services available in our project (REST APIs)
	
	-> Service registry will provide a dashboard with details of services which are registered (name, status & URL)
	
	-> Eureka Server we are using as a Service Registry
	
	-> If Eureka is running on 8761 then then Discovery Clients can auto register with Eureka Server
	
	Developing Second Service as Eureka Client
	------------------------------------------
	-> Create Spring Boot app with below dependencies
	
	- spring-boot-starter-web
	- spring-cloud-netflix-eureka-client
	
	-> Use @EnableDiscoveryClient annotation at boot start class
	
	-> Create RestController with required methods
	
	-> Configure embedded container port number & application name
	
	-> Run our client application
	
	-> Verify Eureka Server Dashboard (Client should be registered)
	
	Note: Before running client application, make sure Eureka Server Project is Running.
	
	---------------------Eureka Client yml file------------------------
	server:
	 port: 2222
	spring:
	 application:
	  name: HELLO-SERVICE
	eureka:
	 client:
	 service-url:
	  defaultZone: ${DISCOVERY_URL:http://localhost:9761}/eureka/
	 
	 
	 * @param userName
	 * @param userAge
	 * @return
	 */
	@GetMapping(value = { "myNameAge/{name}/{age}" })
	public ResponseEntity<String> giveNameAndAge(@PathVariable("name") String userName,
			@PathVariable("age") String userAge) {
		String response = "Your name is " + userName + ", and you are " + userAge + " years old.";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
