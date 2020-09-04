package com.vj.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class WishUserRestController {

	@Value("${msg: Msg value not found, check config server props}")
	private String msg;

	@GetMapping("/msg")
	public String getMsg() {
		return this.msg;
	}

	//	Resource: https://spring.io/guides/gs/centralized-configuration/

}
