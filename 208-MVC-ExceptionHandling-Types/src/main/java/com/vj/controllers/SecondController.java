package com.vj.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {

	@GetMapping("/date")
	public String dateDisplay(Model model) {
		Date date=null;
		//Raising NPE by calling a method on Null Variable
		date.getDate();
		
		model.addAttribute("date", "Current Date : "+new Date());
		return "displayDate";
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
		model.addAttribute("sadFace", " :( ");
		model.addAttribute("errorMsg", " Oops! Could not get the Date, <br/> our best minds are working on it. \n Please try later ..");
		return "error";
	}
	*/
	
}
