package com.vj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/os","/system"})
public class OsController {

	public OsController() {
		System.out.println("OsController.OsController()");
	}

	@RequestMapping("/")
	public String showHome(Model model) {
		System.out.println("OsController.showHome()");
		model.addAttribute("os", " This is OS Controller !!!");
		return "owner";
	}

	@RequestMapping("/ios")		//default mode : GET
	public String getOwnerOfIos(Model model) {
		System.out.println("OsController.getOwnerOfIos()");
		model.addAttribute("os", "IOS : Apple");
		return "owner";
	}

	@RequestMapping("/android")	//default mode : GET
	public String getOwnerOfAndoid(Model model) {
		System.out.println("OsController.getOwnerOfAndoid()");
		model.addAttribute("os", "Android : Google");
		return "owner";
	}

	@RequestMapping(value = "/oxygen")	//default mode : GET
	public String getOwnerOfOxygen(Model model) {
		System.out.println("OsController.getOwnerOfOxygen()");
		model.addAttribute("os", "Oxygen : Oneplus");
		return "owner";
	}
	
	/**
	here we are using 2 same method with GET mode but HandlerMapper will consider the second 
	one  as its the latest and has the explicit RequiredMethod.GET
	if both have explicit RequiredMethod.GET, HandlerMapper cannot 
	decide and throws ambiguos exception
	*/
	@RequestMapping(value = "/oxygen",method = RequestMethod.GET)	//default mode : GET
	public String getOwnerOfOxygen2(Model model) {
		System.out.println("OsController.getOwnerOfOxygen2() :new ");
		model.addAttribute("os", "Oxygen : Oneplus-new");
		return "owner";
	}
}
