package com.vj.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishApi {

	@GetMapping(value = "/{name}")
	public ResponseEntity<String> wishUser(@PathVariable("name") String user) {
		return new ResponseEntity<String>("Good day, " + user, HttpStatus.OK);
	}

	/**
	 
	 Actuators
	----------------------------
	
	-> We are developing applications using Spring Boot and We are deploying our applications in servers
	
	-> Once application is deployed, several users will access our applications
	
	-> When our application is running in production, it is very important to monitor our application
	
	
	What is Application Monitoring
	------------------------------
	-> Health Check
	
	-> Beans check
	
	-> configProps check
	
	-> Heap Dump
	
	-> Thread Dump 
	
	-> Http Trace etc......
	
	
	-> To monitor our applications easily, Spring Boot provided Actuators.
	
	
	-> Actuators are used to provide 'Production Ready Features' for our application.
	
	
	Working with Actuators
	----------------------
	-> We need to add spring-boot-starter-actuator dependency in pom.xml file
	
	-> Actuators provided several pre-defined endpoints to monitor our application. They are 
	
	1) health
	2) info
	3) beans
	4) mappings
	5) configProps
	6) httpTrace
	7) heapdump
	8) threaddump
	9) shutdown ( It is special endpoint )
	
	-> To access actuator endpoints we should use /actuator as prefix
	
	Ex : http://localhost:9090/actuator/health
	
	
	-> In Spring Boot 1.x v '/actuator' should not be there in URL
	
	-> In Spring Boot 2.x v '/actuator' is mandatory in  URL to access Actuator endpoints
	
	-> When we add 'actuator' starter, by default it will expose 2 endpoints they are 'health' and 'info' (we can access them directley).
	
	-> To expose all the endpoints we shuld write below property
	
	management:
	endpoints:
	web:
	  exposure:
	    include: *
	    exclude: beans
	
	
	 
	 */
}
