package com.vj.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	/*
		@RequestMapping("/homePage")
		public ModelAndView showHome() {
			ModelAndView mod=new ModelAndView();
			mod.addObject("welcome", "Welcome to Spring MVC").setViewName("home");
			return mod;
		}
	 */
	@RequestMapping("/homePage")
	public String showHome(Map<String,String> map) {
		map.put("welcome", "Welcome to Spring MVC");
		return "home";
	}

}
