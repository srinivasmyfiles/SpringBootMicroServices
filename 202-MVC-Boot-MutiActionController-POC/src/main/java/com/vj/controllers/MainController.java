package com.vj.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	/*
		Note : We are using same View(wish.jsp) with different URL mapped to different Model and View data
		We can call this as a Multi-Action-Controller
	 */	
	
	@RequestMapping("/")	//default url pattern
	public ModelAndView showHome() {

		ModelAndView mav=new ModelAndView();
		mav.addObject("wish", "This is a wish messenger !!! ").setViewName("wish");
		return mav;
	}
	
	@RequestMapping("/morning")
	public ModelAndView wishMorning() {
		//create ModelAndView Object to add attributeName, Object
		ModelAndView mav=new ModelAndView();
		//add attrib name and Object repectively and set the View name
		mav.addObject("wish", "Good morning, have a great day ahead !! ").setViewName("wish");
		//return ModelAndView obj
		return mav;
	}

	@RequestMapping("/afternoon")
	public ModelAndView wishAfternoon() {
		ModelAndView mav= new ModelAndView();
		mav.addObject("wish", "Good afternoon fellas !!!").setViewName("wish");
		return mav;
	}

	//	here, Using ModelAndView in the code makes our code tightly coupled/bound to Spring Framework
	//	hence we can use Collections Framework to make it Loosely coupled with the Spring Framework
	@RequestMapping("/evening")
	public String wishEvening(Map<String,Object> map) {
		map.put("wish", "Good evening peeps !!!");
		return "wish";
	}

	@RequestMapping("/night")
	public String wishNight(Map<String,Object> map) {
		map.put("wish", "Good night, watch some movies !!!");
		return "wish";
	}


}
