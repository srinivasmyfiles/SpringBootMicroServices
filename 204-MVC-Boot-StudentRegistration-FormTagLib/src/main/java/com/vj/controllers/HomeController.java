package com.vj.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vj.command.Student;

@Controller
public class HomeController {

	//	version-1

	@GetMapping(value = { "/", "register" })
	public String homePage(Model model) {
		System.out.println("HomeController.homePage()");
		
		List<String> coursesList=new ArrayList<>();
		coursesList.add("Java");
		coursesList.add("Python");
		coursesList.add("DevOps");
		coursesList.add("Data Structures");
		
		model.addAttribute("courses", coursesList);
		
		List<String> timingsList=new ArrayList<>();
		timingsList.add("Morning");
		timingsList.add("Afternoon");
		timingsList.add("Evening");
		timingsList.add("Graveyard");
		
		model.addAttribute("timingsList", timingsList);
		
		
		Student s = new Student();
		//set model data as key/value
		model.addAttribute("student", s);
		//return lvn
		return "studReg";
	}

	@PostMapping("/registerPage")
	public String registered(@ModelAttribute("student") Student s, Model model) {
		System.out.println("HomeController.registered()");
		//set model data as key/value
		model.addAttribute("result", "Regsitration Success, following are your details!!");

		//return lvn
		//return "studReg";
		//request redirection to another view
		return "regSuccess";
	}



	//	__________________________________________________________

	/**
			@ModelAttribute annotation makes this method to use 
			the model obj param to apply for any post/get request
			It can be allpied at method level and method param.
	 */

	//version-2

	/*	
				@ModelAttribute(name = "student")
				public void init(Model model) {
				System.out.println("HomeController.init()");
				Student s=new Student();
				model.addAttribute("student", s);
				}


				@GetMapping(value = {"/","register"})
				public String homePage() {
				System.out.println("HomeController.homePage()");
				return "studReg";
				}

				@PostMapping("/registerPage")
				public String registered(@ModelAttribute("student") Student s) {
				System.out.println("HomeController.registered()");
				return "regSuccess";
				}



	 */

}
