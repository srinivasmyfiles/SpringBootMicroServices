package com.vj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mc") //controller specific url
public class MainController {

	/**
	 * Scenario 1 : One PathParameter in URL
	 * > This resource method is mapped to /myname/{name} URL.
	 * > /myname is considered as URL, and {name} considered as PathParameter.
	 * > Position of PathParameter value must match with PathParameter position in URL.
	 * > URL e.g., : http://localhost:2525/mc/myname/john
	 * > Same URL can be there with GET mapping, but the PathParam variables should be different.
	 * > here, john is the value for PathParamter {name}.
	 * @param name
	 * @return
	 */
	@GetMapping("/myname/{name}")
	public String verifyMyName(@PathVariable("name") String name) {
		if (name.equalsIgnoreCase("vijay") || name.equalsIgnoreCase("john"))
			return " Welcome " + name + ".";
		else
			return " You are not registered " + name + ".";
	}

	/**
	 * > Looks like a similar method to the above one but 
	 * 	 with different PathParam variables "{myname}/{profession}". So this is a different URL. 
	 * > URL e.g., : http://localhost:2525/mc/myname/vijay/developer
	 * @param name
	 * @param designation
	 * @return
	 */
	@GetMapping("/myname/{myname}/{profession}")
	public String MyName(@PathVariable("myname") String name, @PathVariable("profession") String designation) {
		if (name.equalsIgnoreCase("vijay") || name.equalsIgnoreCase("john"))
			return " Welcome " + name + ", you are a " + designation + ".";
		else
			return " You are not registered " + name + ".";
	}

	/**
	 * Scenario 2 : Multiple PathParamters in URL.
	 * > This resource method is mapped with "/buyphone/{company}/{model}/{storage}" URL.
	 * > Multiple PathParameter values must be separated by /.
	 * > Positions of values must match respectively.
	 * > URL e.g., : http://localhost:2525/mc/buyphone/oneplus/8pro/256
	 * > here, the values after /buyphone/ are assigned and initialized to their respective 
	 * 	 PathParamter positions respectively by Dispatcher Servlet.
	 * @param manufacturer
	 * @param model
	 * @param storage
	 * @return
	 */
	@GetMapping("/buyphone/{company}/{model}/{storage}")
	public String purchasePhone(@PathVariable("company") String manufacturer, @PathVariable("model") String model,
			@PathVariable("storage") Integer storage) {

		if (manufacturer.equalsIgnoreCase("apple") && model.equalsIgnoreCase("11pro") && storage.equals(256))
			return "Yay!! " + manufacturer + " " + model + " with " + storage + "GB is available.";

		else if (manufacturer.equalsIgnoreCase("oneplus") && model.equalsIgnoreCase("8Pro") && storage.equals(256))
			return "Yay!! " + manufacturer + " " + model + " with " + storage + "GB is available.";

		else if (manufacturer.equalsIgnoreCase("google") && model.equalsIgnoreCase("Pixel4") && storage.equals(128))
			return "Yay!! " + manufacturer + " " + model + " with " + storage + "GB is available.";

		else
			return "Oops! Sorry, it is unavailable right now. Try again with different company/model/storage";
	}

	/**
	 * Scenarios 3 : Multiple PathParams in the middle of the URL.
	 * > This resource method is mapped with "/bookflight/from/{from}/to/{to}" URL.
	 * > PathVariable name and URL names could be same but differentiated by {}.
	 * > Positions must match.
	 * > URL e.g., http://localhost:2525/mc/bookflight/from/india/to/srilanka
	 * > here, India and Srilanka are part of URL as PathParam values, rest of it is URL.
	 * 
	 * Valid URLs :
	 * http://localhost:2525/mc/bookflight/from/india/to/srilanka
	 * http://localhost:2525/mc/bookflight/from/hyderabad/to/goa
	 * http://localhost:2525/mc/bookflight/from/hyderabd/to/bangalore
	 * 
	 * Invalid URLs :
	 * http://localhost:2525/mc/bookflight/from/india/srilanka	- /to/ is missing
	 * http://localhost:2525/mc/bookflight/india/to/srilanka 	- /from/ is missing
	 * http://localhost:2525/mc/bookflight/india/srilanka		- /to/ and /from/ are missing
	 * 
	 * @param source
	 * @param dest
	 * @return
	 */
	@GetMapping("/bookflight/from/{from}/to/{to}")
	public String bookPlane(@PathVariable("from") String source, @PathVariable("to") String dest) {
		return "Flight booked from : " + source + " to : " + dest + ".";
	}
}

/** 
 * Important Points : 
 *
 -> RESTful Services / REST API / Spring REST API :
  
     @RequestParam : It is used to represent a "Request Parameter" in a URL of RESTful Services.
  
     @PathVariable : It  is used to represent a "Path Parameter" in a URL of RESTful Services
   
 
 -> SOAP / XML WebServices : 
 
     @QueryParam : It is used to represent a "Request Parameter" in a URL of SOAP WebServices.  

     @PathParam: It  is used to represent a "Path Parameter" in a URL of SOAP WebServices.

 * ---------------------------------------------------------------------------
 * Class Notes: 
 * 
Today's session: Path Parameters in REST API
-----------------------------------------------
08-Jul-2020
----------------------------------------------

-> Request Params are called as Query Parameters

-> Query Params are used to send data to server in the URL using key-value pair format

-> Query Params should be present only at end of the URL

-> Query Params starts with ? and seperated by &

Ex: www.ashokit.in?course=jrtp&trainer=ashok

How to access Query Parameters in REST Controller
--------------------------------------------------
-> By using @RequestParam annotation we can access Query Parameters coming in the URL

@GetMapping("/hello")
public String sayHello(@RequestParam("name") String s){
	return "Hello, "+name;
}

-> By Default Query Params are mandatory in Spring MVC

Working with Multiple Query params in REST API
-----------------------------------------------
@GetMapping("/course")
	public String getCourseDetails(@RequestParam("cname") String courseName,
			@RequestParam("tname") String trainerName) {

		if (courseName.equals("JRTP") && trainerName.equals("Ashok")) {
			return "Starting from 20-July-2020 @11:30 AM IST";
		}

		return "Please Check Our Website http://www.ashokit.in For More Details";
	}



Path Parameter
--------------
-> Path Parameters are called as URI parameters

-> Path Parameters are used to send data from client to server in URL

Ex: www.ashokit.in/course/{JRTP}/{Ashok}

-> Path Parameters Can Present Anywhere in the URL

Ex : www.ashokit.in/course/{JRTP}/fastrack/{Ashok}


Working with Path Parameters in Rest Controller
-----------------------------------------------
-> To Read Path Parameters in RestController we will use @PathVariable annotation.

We will work with below 3 examples
----------------------------------
1) Working with Single Path Parameter
2) Working with more than one path parameter
3) Working with Path Params in Middle Of URL

URL pattern : www.ashokit.in/course/name/{course-name}
Actual URL : www.ashokit.in/course/name/jrtp


Single Path Parameter
---------------------
@GetMapping(value = "/course/{name}")
	public String getCourseDuration(@PathVariable("name") String courseName) {
		if ("JRTP".equals(courseName)) {
			return "Duration : 3 Months";
		} else if ("SBMS".equals(courseName)) {
			return "Duration : 75 Days";
		} else {
			return "Please check our website for more details : www.ashokit.in";
		}
	}

Multiple Path Parameters
------------------------
@GetMapping(value="/course/{cname}/{tname}")
	public String getCourseDetails(
				@PathVariable("cname") String cname, 
				@PathVariable("tname") String tname) {
		
		if ("JRTP".equals(cname) && "Ashok".equals(tname)) {
			return "Starting new batch From 20-Jul-2020 @11:30 AM IST";
		} else if ("SBMS".equals(cname) && "Ashok".equals(tname)) {
			return "Starting new batch from 29-Jul-2020 @7:15 AM IST";
		} else {
			return "Please check our website for more details : www.ashokit.in";
		}
	}

Using Path Params in Middle Of URL
-----------------------------------
@GetMapping(value = "/course/{cname}/fastrack/{tname}")
	public String getDetails(@PathVariable("cname") String cname,
	 						 @PathVariable("tname") String name) {
		return "Registration Process Is Started";
	}


*/