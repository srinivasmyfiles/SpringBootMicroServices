package com.vj.request;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class PassengerDetails {

	String coachType;
	String dateOfJourney;
	String firstName;
	String from;
	String lastName;
	Integer passengerAge;
	String passengerGender;
	String to;
	
}
