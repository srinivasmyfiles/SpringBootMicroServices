package com.vj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vj.exceptions.InvalidIdException;
import com.vj.service.EmployeeService;

@Controller
public class PercentageController {

	@Autowired
	EmployeeService service;

	/**
	 * http://localhost:2525/phone?id=123
	 * Take GET request with ID value in the URL
	 * Throws a User Defined Exception, if we pass 'id' other than '123'.
	 * @param id
	 * @param model
	 * @return
	 */

	@GetMapping("/phone")
	public String givePercentage(@RequestParam("id") String id,Model model) {

		Double percentage = service.getPercentageById(id);
			//add the received number to model attribute as key/value
			model.addAttribute("percentage", "percentage is : "+percentage);
			//return LVN
			return "percentage";
	}


}
