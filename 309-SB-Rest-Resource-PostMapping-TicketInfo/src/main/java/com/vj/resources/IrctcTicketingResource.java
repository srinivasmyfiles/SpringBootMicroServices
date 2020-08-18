package com.vj.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vj.request.PassengerDetails;
import com.vj.response.TicketDetails;

@RestController
public class IrctcTicketingResource {

	/**
	 > RESOURCE side :
	 
	  1. produces : to inform "Client" the type of response supported by "Resource".
	  
	  2. consumes : to inform "Client" the type of requests accepted/expected by "Resource".
	---------------------------------------------------------------------------
	 > CLIENT side :
	  
	  1. accept header : to inform "Resource" the type of response "Client" expecting/accept.
	  
	  2. content-type header : to inform "Resource" the type of data "Client" is Sending 
		 with "Request Body".
	---------------------------------------------------------------------------
	 >> Client can send :  <<
	 
	 1. Xml format :
	   
	  <?xml version="1.0" encoding="UTF-8"?>
			<passenger-info>
				<firstName>Vijay</firstName>
				<lastName>Muccharla</lastName>
				<passengerGender>Male</passengerGender>
				<passengerAge>26</passengerAge>
				<dateOfJourney>15-08-2020</dateOfJourney>
				<to>Bangalore</to>
				<from>Hyderabad</from>
				<coachType>AC</coachType>
			</passenger-info>
		
	 2. Json format :
	 
	  {
	  	"firstName":"Vijay",
	  	"lastName":"Muccharla",
	  	"passengerAge":"26",
	  	"passengerGender":"Male",
	  	"dateOfJourney":"18-08-2020",
	  	"to":"Chennai",
	  	"from":"Bangalore",
	  	"coachType":"Non-AC"
	  }
	 ---------------------------------------------------------------------------
	 
	 >> Resource can send(produces) response in both XML / Json format based on 
	 	client acceptHeader value. <<
	 ---------------------------------------------------------------------------
	 >> By default, RestAPI will send response with 200(OK) HTTP status code 
	 	as per "produces" attribute.
	 >> If we want to return response with different(modify) status code then we have 
		to use ResponseEntity concept.
	 	
	 ex:1
	 
@PostMapping(value = "/bookTicket", produces = { "application/xml", "application/json" },
	 								consumes = {"application/xml", "application/json" })
		public TicketDetails bookTicket(@RequestBody PassengerDetails pDetails){
			return ticket;
		}
		
	 	> This Rest Resource method will return TicketDetails with status 
	 	code 200(ok) by default.
	 	
	 ---------------------------------------------------------------------------
	 ex:2
	 
@PostMapping(value = "/bookTicket2", produces = { "application/xml", "application/json" },
	   								 consumes = {"application/xml", "application/json" })
  public ResponseEntity<TicketDetails> bookATicket(@RequestBody PassengerDetails pDetails) {
		return new ResponseEntity<TicketDetails>(ticket,HttpStatus.CREATED);
  }
  
  >This resource method will return, ResponseEntity with the given TicketDetails body and 
  the given HttpStatus code, 201(CREATED).
	 
	 ---------------------------------------------------------------------------
	 Notes : 21st July
	 
	 -> To bind our rest api method to POST request we will use @PostMapping annotation
	 
	 -> consumes attribute represents input data formats supported by method

	-> produces attribute represents output data formats supported by method
	
	-> When client is sending request to above method, he should sent two HTTP 
	Headers in request
	
		a)Content-Type
		b)Accept
	
	-> Content-Type header represents input data format sending by client.
	
	-> Accept Header represents output data format expecting by client.
	
	-> POST Request Means Creating Record/Resource at server. If POST Request 
	operation is successful it should represent with HTTP 201 status code.
	
	
	-> By default, rest controller methods response sending to cient 200 as 
	status code which means OK.
	
	-> If we want to return response with different status code then we have 
	to use ResponseEntity concept.
	
	Who is construcing response at API side?
	----------------------------------------
	-> DispatcherServlet
_________________________________________________________________________________________
	 * @param pDetails
	 * @return
	 */
	@PostMapping(value = "/bookTicket1", produces = { "application/xml", "application/json" }, consumes = {
			"application/xml", "application/json" })
	public ResponseEntity<TicketDetails> bookTicket(@RequestBody PassengerDetails pDetails) {

		System.out.println(pDetails);
		TicketDetails ticket = new TicketDetails();
		ticket.setTicketId("BA89H601");
		ticket.setPassengerName(pDetails.getFirstName() + " " + pDetails.getLastName());
		ticket.setPassengerAge(pDetails.getPassengerAge());
		ticket.setPassengerGender(pDetails.getPassengerGender());
		ticket.setDepartureDate(pDetails.getDateOfJourney());
		ticket.setFrom(pDetails.getFrom());
		ticket.setTo(pDetails.getTo());
		ticket.setJourneyClass(pDetails.getCoachType());

		return new ResponseEntity<TicketDetails>(ticket, HttpStatus.OK);

	}
	
	@PostMapping(value = "/bookTicket2", produces = { "application/xml", "application/json" }, consumes = {
			"application/xml", "application/json" })
	public ResponseEntity<TicketDetails> bookATicket(@RequestBody PassengerDetails pDetails) {

		System.out.println(pDetails);
		TicketDetails ticket = new TicketDetails();
		ticket.setTicketId("BA89H601");
		ticket.setPassengerName(pDetails.getFirstName() + " " + pDetails.getLastName());
		ticket.setPassengerAge(pDetails.getPassengerAge());
		ticket.setPassengerGender(pDetails.getPassengerGender());
		ticket.setDepartureDate(pDetails.getDateOfJourney());
		ticket.setFrom(pDetails.getFrom());
		ticket.setTo(pDetails.getTo());
		ticket.setJourneyClass(pDetails.getCoachType());

		return new ResponseEntity<TicketDetails>(ticket,HttpStatus.CREATED);

	}
}
