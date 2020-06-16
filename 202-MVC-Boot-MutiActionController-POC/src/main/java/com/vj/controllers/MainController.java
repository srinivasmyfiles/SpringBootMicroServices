package com.vj.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//class level URL to differentiate between multiple Controller methods URLs
@RequestMapping("/main")
public class MainController {
	/*
		Note : We are using same View(wish.jsp) with different URL mapped to different Model and View data
		We can call this as a Multi-Action-Controller
	 */	

	public MainController() {
		System.out.println("MainController.MainController()");
	}


	//	@RequestMapping("/")	//default url pattern //default mode : GET
	@RequestMapping(value = {"/","/home"})	//Multiple URLs for same method
	public ModelAndView showHome() {
		System.out.println("MainController.showHome()");

		ModelAndView mav=new ModelAndView();
		mav.addObject("wish", "This is Main Controller !!! ").setViewName("wish");
		return mav;
	}

	//default mode of any method is GET, to change we have to use method=RequestMethod.POST/GET
	//	@RequestMapping("/morning")		//default mode : GET
	@RequestMapping(value = "/morning",method = RequestMethod.GET)	//GET optional
	public ModelAndView wishMorning1() {
		//create ModelAndView Object to add attributeName, Object
		System.out.println("MainController.wishMorning1()  : GET");
		ModelAndView mav=new ModelAndView();
		//add attrib name and Object repectively and set the View name
		mav.addObject("wish", "Good morning, have a great day ahead !! ").setViewName("wish");
		//return ModelAndView obj
		return mav;
	}


	//two same URLs allowed only if they use GET and POST modes individually
	//Post methods will be called when the request if setn as POST from UI with Request Body(DATA)
	@RequestMapping(value = "/morning",method = RequestMethod.POST)	
	public ModelAndView wishMorning2() {
		//create ModelAndView Object to add attributeName, Object
		System.out.println("MainController.wishMorning2() : POST");
		ModelAndView mav=new ModelAndView();
		//add attrib name and Object repectively and set the View name
		mav.addObject("wish", "Good morning, have a great day ahead !! ").setViewName("wish");
		//return ModelAndView obj
		return mav;
	}



	@RequestMapping("/afternoon")	//default mode : GET
	public ModelAndView wishAfternoon() {
		System.out.println("MainController.wishAfternoon()");
		ModelAndView mav= new ModelAndView();
		mav.addObject("wish", "Good afternoon fellas !!!").setViewName("wish");
		return mav;
	}

	//	here, Using ModelAndView in the code makes our code tightly coupled/bound to Spring Framework
	//	hence we can use Collections Framework to make it Loosely coupled with the Spring Framework
	@RequestMapping("/evening")	//default mode : GET
	public String wishEvening(Map<String,Object> map) {
		System.out.println("MainController.wishEvening()");
		map.put("wish", "Good evening peeps !!!");
		return "wish";
	}

	@RequestMapping("/night")	//default mode : GET
	public String wishNight(Map<String,Object> map) {
		System.out.println("MainController.wishNight()");
		map.put("wish", "Good night, watch some movies !!!");
		return "wish";
	}

	@RequestMapping("/gnight")	//default mode : GET
	public String wishGnight(Model model) {
		System.out.println("MainController.wishGnight()");
		model.addAttribute("wish", "Good night, sleep off !!!");
		return "wish";
	}

	//same URL available in OsController, we differentiate them with Class level URL pattern
	@RequestMapping("/ios")	//default mode : GET
	public String getOwnerOfIos(Model model) {
		System.out.println("MainController.getOwnerOfIos() : MainController");
		model.addAttribute("os", "IOS : Apple");
		return "owner";
	}

}
