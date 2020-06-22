package com.vj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vj.command.Student;

@Controller
public class HomeController {

	@GetMapping(value = {"/","register"})
	public String homePage(Model model) {
		Student s= new Student();
		model.addAttribute("student", s);
		return "studReg";
	}
	
	@PostMapping("/registerPage")
	public String registered(@ModelAttribute("student") Student s, Model model) {
		model.addAttribute("result", "Regsitration Success !!");
		return "studReg";
	}
}
