package com.vj.response;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

/**
 * > @XmlRootElement mandate to mention for representing response format to XML.
 * > All other XML and JSon annotations are optional, the variable name itself will 
 * be takes as element names.
 * @author vkmuc
 *
 */
@Data
@XmlRootElement(name = "ticket-info")
public class TicketDetails {

	private String ticketId;
	private String passengerName;
	private Integer passengerAge;
	private String passengerGender;
	private String departureDate;
	private String from;
	private String to;
	private String journeyClass;
	
}
