package com.vj.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vj.configprops.ConfigProperties2;

@RestController
public class TestRestController {

	@Autowired
	//	ConfigProperties1 props;
	ConfigProperties2 props;

	@GetMapping("/wish")
	public String getWishMsg() {
		//		return props.getWishMsg(); 
		return props.getProperties().get("wishMsg");
	}

	@GetMapping("/bye")
	public String getByeMsg() {
		//		return props.getByeMsg(); 
		return props.getProperties().get("byeMsg");
	}

}
