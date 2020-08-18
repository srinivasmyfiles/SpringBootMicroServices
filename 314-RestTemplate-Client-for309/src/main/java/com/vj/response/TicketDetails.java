package com.vj.response;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class TicketDetails {

	String departureDate;
	String from;
	String journeyClass;
	Integer passengerAge;
	String passengerGender;
	String passengerName;
	String ticketId;
	String to;
}
