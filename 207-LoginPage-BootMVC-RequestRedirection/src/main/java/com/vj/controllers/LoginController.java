package com.vj.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@GetMapping(value = {"/" , "/login"})
	public String loginPage() {
		System.out.println("LoginController.loginPage()");
		return "login";
	}

	/**
	 * 1. Redirecting request (@line number- 40 & 44) to another GET method to separate 
	 *    DashBoard logic and avoid Double posting problem
	 * 2. RequestAttrbutes are used to flash the added Attributes Data
	 * 	  to the method we are redirecting the incoming request.
	 * 3. Hence we are redirecting the "dashboard" request if credentials are valid,
	 * 	  else redirect to "Login" page. This is called PRG(Post Return Get) Pattern
	 * 	  to avoid double posting of data if we refresh the POST request.
	 * @param req
	 * @param attributes
	 * @return
	 */
	
	@PostMapping("/login")
	public String loginButton(HttpServletRequest req,RedirectAttributes attributes) {
		System.out.println("LoginController.loginButton()");
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		if(uname.equalsIgnoreCase("vijay") && pwd.equalsIgnoreCase("vijay@123")) { 
			attributes.addFlashAttribute("msg", uname);
			return "redirect:/dashboard";
		}
		else {
			attributes.addFlashAttribute("msg"," Invalid Credentials");
			return "redirect:/login";
		}
		
	}
	
	@GetMapping("/dashboard")
	public String dashBoard(Model model) {
		System.out.println("LoginController.dashBoard()");
		model.addAttribute("loginMsg", "Dashboard is loading...");
		return "dashboard";
	}
}
