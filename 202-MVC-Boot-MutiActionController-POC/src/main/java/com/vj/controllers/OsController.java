package com.vj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OsController {

	@RequestMapping("/ios")
	public String getOwnerOfIos(Model model) {
		model.addAttribute("os", "IOS : Apple");
		return "owner";
	}
	
	@RequestMapping("/android")
	public String getOwnerOfAndoid(Model model) {
		model.addAttribute("os", "Android : Google");
		return "owner";
	}
	
	@RequestMapping("/oxygen")
	public String getOwnerOfOxygen(Model model) {
		model.addAttribute("os", "Oxygen : Oneplus");
		return "owner";
	}
	
	
}
