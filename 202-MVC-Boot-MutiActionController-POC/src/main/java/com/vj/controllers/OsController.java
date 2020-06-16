package com.vj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		model.addAttribute("os", "Android : Google");
		return "owner";
	}

	@RequestMapping("/oxygen")	//default mode : GET
	public String getOwnerOfOxygen(Model model) {
		model.addAttribute("os", "Oxygen : Oneplus");
		return "owner";
	}


}
