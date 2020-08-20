package com.vj.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vj.restclient.NameAndAgeClient;

@RestController
public class WishUserRestController {

	@Autowired
	private NameAndAgeClient client;

	/**
	 
	 
	-> We have created below 3 applications
	
	1) Service-Registry (Port Number : 4545) - Eureka Server
	
	2) HI-SERVICE (Port Number : 2525) - Eureka Client-1
	
	3) HELLO-SERVICE (Port NumBer : 3535) - Eureka Client-2
	
	Inter-Service Communication
	---------------------------
	In our project, if one micro-services accessing another microserice then it is called as Inter-service communication.
	
	Note: Both Microservices are available in Same Project.
	
	-> We can use Rest Client logic to access another REst API
	
	Working with FeginClient
	------------------------
	<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-openfeign</artifactId>
	</dependency>
	 -----------------------------
	 * @param username
	 * @return
	 */
	@GetMapping(value = { "wish/{name}" })
	public ResponseEntity<String> wishMe(@PathVariable("name") String username) {
		String msg = "Have a great future ahead " + username + ".";
		String anotherRestApiResponse = client.invokeGiveNameAndAgeMethod("Mani", "22");
		String interServiceCommResponse = "WishUserResponse : " + msg + "\n NameAndAgeRestApi response : "
				+ anotherRestApiResponse;
		return new ResponseEntity<>(interServiceCommResponse, HttpStatus.OK);
	}

}
