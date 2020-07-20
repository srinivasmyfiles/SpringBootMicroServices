package com.vj.resources;

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
	 
	 >> Resource can send response in both XML / Json format based on 
	 	client acceptHeader value. <<
	 ---------------------------------------------------------------------------
	 * @param pDetails
	 * @return
	 */
	@PostMapping(value = "/bookTicket", produces = { "application/xml", "application/json" }, consumes = {
			"application/xml", "application/json" })
	public TicketDetails bookTicket(@RequestBody PassengerDetails pDetails) {

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

		return ticket;

	}
}
