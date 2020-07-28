package com.vj.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vj.request.Book;

@RestController
public class BookController {

	/**
	 Today's session : HATEOS example
	--------------------------------------------------------
	
	REST Architecture Principles
	-----------------------------
	1) Unique Addressability
	2) Uniform Contraint Interfaces
	3) Message Oriented Representation
	4) Communication Stateless
	5) HATEOS (Hypermedia as the engine of application state)
	
	-> HATOES is next level component in REST API.
	
	-> Using this HATEOS Rest Resources will provide information dynamically through Hyper media
	
	Scenario
	----------
	Client sent request to REST API to get Book Information based on ID
	
	Client Requested URL : www.amazon.in/book/101
	
	Then Server sent Book Information as Response like below
	
	{
	  "id"  : 101,
	  "name" : "Spring",
	  "price" : "500$",
	  "author" : "Rod Johnson"
	}
	
	USING HATEOS
	------------
	Server can send response like below
	
	{
	  "id"  : 101,
	  "name" : "Spring",
	  "price" : "500$",
	  "author" : "Rod Johnson",
	   "all-books" {
	    "href" : "www.amazon.in/books/rodjohnson"
	}
	}
	
	
	
	Develop a rest api which provides response using HATEOS
	-------------------------------------------------------
	
	Note: To work with HATEOAS, spring boot provided starter pom
	
	<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-hateoas</artifactId>
	</dependency>
	
	
	-------------------------------------------
	->Extend Model calss from org.springframework.hateoas.RepresentationModel<T>
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class Book extends RepresentationModel<Book> {
	
	private String isbn;
	private String name;
	private Double price;
	private String author;
	
	}
	 
	 ------------------------------------------------
	 -> add link of the method URL you want using WebMvcLinkBuilder.linkTo()
	 
	@RestController
	public class BookRestController {
	
	@GetMapping(value = "/book/{isbn}", produces = "application/json")
	public Book getBookInfo(@PathVariable("isbn") String isbn) {
		// logic
		Book b = new Book(isbn, "Spring", 300.00, "Rod Johnson");
	
		Link withRel = WebMvcLinkBuilder.linkTo(
						WebMvcLinkBuilder.methodOn(BookRestController.class)
						.getAllBooks())
						.withRel("All-Books");
		
		b.add(withRel);
		
		return b;
	}
	
	@GetMapping(value="/books", produces="application/json")
	public List<Book> getAllBooks() {
		Book b1 = new Book("ISBN001", "Spring", 300.00, "Rod Johnson");
		Book b2 = new Book("ISBN002", "Spring Boot", 400.00, "Rod Johnson");
		Book b3 = new Book("ISBN003", "Spring Cloud", 200.00, "Rod Johnson");
	
		List<Book> books = new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
	
		return books;
	} 
	  
	 * @param isbn
	 * @return
	 */
	@GetMapping(value = "/book/{isbn}", produces = "application/json")
	public Book getBookInfo(@PathVariable("isbn") String isbn) {
		// logic
		Book b = new Book(isbn, "Spring", 300.00, "Rod Johnson");

		Link withRel = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks())
				.withRel("All-Books");

		b.add(withRel);

		return b;
	}

	@GetMapping(value = "/books", produces = "application/json")
	public List<Book> getAllBooks() {
		Book b1 = new Book("ISBN001", "Spring", 300.00, "Rod Johnson");
		Book b2 = new Book("ISBN002", "Spring Boot", 400.00, "Rod Johnson");
		Book b3 = new Book("ISBN003", "Spring Cloud", 200.00, "Rod Johnson");

		List<Book> books = new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		books.add(b3);

		return books;
	}
}