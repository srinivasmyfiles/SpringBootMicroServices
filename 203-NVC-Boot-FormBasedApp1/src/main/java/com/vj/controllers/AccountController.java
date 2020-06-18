package com.vj.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

	@GetMapping(value = "/register")
	public String signUpHome() {
		return "signup";
	}

	@PostMapping(value = "/register")
	public String signUpResult(HttpServletRequest req,Model model) {
		String uname = req.getParameter("uname");
		System.out.println(" Username : "+uname);
		String pwd = req.getParameter("pwd");
		System.out.println(" Password : "+pwd);
		String email = req.getParameter("email");
		System.out.println(" Emial : "+email);
		String phone = req.getParameter("phone");
		System.out.println(" Phone : "+phone);

		model.addAttribute("result", " Registration Successful !! ");
		return "signupresult";
	}


}
