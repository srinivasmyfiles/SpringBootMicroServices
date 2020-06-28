package com.vj.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * This is Global Controller Exception Handler, 
	 * i.e. To handle NullPointerException raised in any of the controllers of this Application
	 * @param model
	 * @return
	 */
	@ExceptionHandler(value = NullPointerException.class)
	public String nullPointerExceptionHandler(Model model) {
		model.addAttribute("errorMsg","Global : Something went wrong, please try again later ! ");
		return "error";
	}

	/**
	 * This is Global Controller Exception Handler, 
	 * i.e. To handle InvalidIdException raised in any of the controllers of this Application
	 * @param model
	 * @return
	 */

	@ExceptionHandler(value = InvalidIdException.class)
	public String invalidIdExceptionHanlder() {
		return "errorPage";
	}
	
}
