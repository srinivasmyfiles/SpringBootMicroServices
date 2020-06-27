package com.vj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vj.binding.BookBinding;
import com.vj.services.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService service;

	@GetMapping(value = { "/" , "/newBookEntry" } )
	public String homePage(Model model) {

		BookBinding emptyBook=null;
		//empty BookBinding obj to bind form data
		emptyBook= new BookBinding();
		//add obj to Model Attribute
		model.addAttribute("book", emptyBook);
		//return logical view name of home page
		return "addBook";
	}
	
	@PostMapping("/newBookEntry")
	public String addBookButton(@ModelAttribute("book") BookBinding book, RedirectAttributes attributes) {
		//use service to save record
		boolean bookAdded = service.save(book);
		if(bookAdded)
			attributes.addFlashAttribute("result", " Book added successfully ! ");
		else
			attributes.addFlashAttribute("result", " Could not add the Book ! ");
		//return lvn of same page with result message to GET for PRG pattern
		return "redirect:/newBookEntry";
	}
	
	@GetMapping("/viewAllBooks")
	public String viewAllBooks(Model model) {
		//get all books using service
		List<BookBinding> allBooks = service.getAllBooks();
		//add the list of books to model attribute
		model.addAttribute("books", allBooks);
		//return lvn of all books view
		return "Books";
	}
}
