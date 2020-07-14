package com.vj.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.vj.commands.User;

@Controller
public class AccountController {

	@GetMapping(value = "/register")
	public String signUpHome() {
		return "signup";
	}

	@PostMapping(value = "/register")
	public String signUpResult(HttpServletRequest req, Model model) {
		String uname = req.getParameter("uname");
		System.out.println(" Username : " + uname);
		String pwd = req.getParameter("pwd");
		System.out.println(" Password : " + pwd);
		String email = req.getParameter("email");
		System.out.println(" Emial : " + email);
		String phone = req.getParameter("phone");
		System.out.println(" Phone : " + phone);

		model.addAttribute("result", " Registration Successful !! ");
		return "signupresult";
	}

	/**
	 * HttpServletRequest ---> To capture data coming in Request
	
	String name = req.getParameter("uname");
	
	-> If we have more fields in form then we should write boiler plate code to capture form data.
	
	-> In application we will have several forms and every form will have several fields then we should 
	write lot of boiler plate code in our application.
	
	-> To avoid this boiler plate code, Spring MVC provided Form Binding Object mechanism(Command Class).
	 * 
	 */
	@GetMapping(value = "/signup")
	public String signUpPage() {
		return "signup";
	}

	/**
	 * 	> here User acts as a form binding obj(command cls obj),
		> it has the fields with same name as form fields.
		> DS maps the form fields with Form binding obj properties
	 * @param user
	 * @param model
	 * @return
	 */
	@PostMapping(value = "signup")
	public String signUpResult(User user, Model model) {

		System.out.println(user);

		model.addAttribute("result", "Signup Successful");

		return "signupresult";

	}

}
