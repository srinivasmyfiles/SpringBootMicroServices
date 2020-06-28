package com.vj.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vj.command.Student;

@Controller
public class HomeController {

	//Logger with Console Appender 
	private static final Logger logger=LoggerFactory.getLogger(HomeController.class);

	/** 
	 * This method is for GET request to load Registration form
	 * @param model
	 * @return
	 */

	@GetMapping(value = { "/", "register" })
	public String homePage(Model model) {
		logger.info(" GET : Registration Form loaded ");
		
		//set model data as key/value
		model.addAttribute("student", new Student());
		
		//return lvn
		return "studReg";
	}
	/**
	 * 1. This method is for POST request to capture the form data.
	 * 2. RequestAttributes (flashAttributes) are used to forward the
	 * model attributes from one request Method to another request Method
	 * while redirecting the incoming request.
	 *  
	 * @param student
	 * @param attribs
	 * @return
	 */
	
	@PostMapping("/registerPage")
	public String registered(@ModelAttribute("student") Student student, RedirectAttributes attribs) {
		logger.info(" POST : Form submitted with : "+student);
		
		//business logic to insert/update/delete operation
		
		//set model data as key/value
//		model.addAttribute("result", " Regsitration Success, following are your details !! ");
		attribs.addFlashAttribute("result", " Regsitration Success, details are submitted  !! ");
		attribs.addFlashAttribute("student", student);
		
		//redirect to GET mode req for avoiding "Double Posting" problem
		return "redirect:/registerResult";
	}
	
	/**
	 * This method is for taking redirected POST request 
	 * redirected from another POST method(To achieve PRG pattern)
	 * @param model
	 * @return
	 */
	@GetMapping("/registerResult")
	public String regResult(Model model) {
		logger.info(" POST Request redirected to GET ");
		
		//return Logical View Name
		return "regSuccess";
	}
	
}
