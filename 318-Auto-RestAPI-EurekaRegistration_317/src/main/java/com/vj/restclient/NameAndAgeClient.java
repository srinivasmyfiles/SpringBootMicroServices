package com.vj.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "NAMEANDAGE-Service")
public interface NameAndAgeClient {

	@GetMapping(value = "myNameAge/{name}/{age}")
	public String invokeGiveNameAndAgeMethod(
												@PathVariable("name") String uname, 
												@PathVariable("age") String age
											);
}
