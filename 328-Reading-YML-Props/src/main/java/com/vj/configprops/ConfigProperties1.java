package com.vj.configprops;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties
@ConfigurationProperties(prefix = "test")
@Configuration
public class ConfigProperties1 {

	private String wishMsg;
	private String byeMsg;

	public String getWishMsg() {
		return wishMsg;
	}

	public void setWishMsg(String wishMsg) {
		this.wishMsg = wishMsg;
	}

	public String getByeMsg() {
		return byeMsg;
	}

	public void setByeMsg(String byeMsg) {
		this.byeMsg = byeMsg;
	}

	@Override
	public String toString() {
		return "ConfigProperties [wishMsg=" + wishMsg + ", byeMsg=" + byeMsg + "]";
	}

}
