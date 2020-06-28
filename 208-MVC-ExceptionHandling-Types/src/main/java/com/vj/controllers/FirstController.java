package com.vj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

	@GetMapping("/name")
	public String first(Model model) {

		//Raising NullPointerExcetion, by calling a method on a null variable
		String name=null;
		name.isEmpty();
		//adding model data in key/value format
		model.addAttribute("name", "My name is Vijay Muccharla");
		return "name";
	}
	
	/**
	 * To handle the NullPointerException 
	 * This is Controller Based Handler, i.e. Specific to this Controller only
	 * @param model
	 * @return
	 */
	
	/*
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNPE(Model model) {
		model.addAttribute("sadFace", " :'( ");
		model.addAttribute("errorMsg", " Oops! something went wrong, <br/> our best minds are working on it. \n Please try later ..");
		return "error";
	}
	
	*/

}
