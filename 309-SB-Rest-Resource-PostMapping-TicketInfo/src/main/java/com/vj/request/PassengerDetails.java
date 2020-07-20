package com.vj.request;

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
@XmlRootElement(name = "passenger-info")
public class PassengerDetails {

	private String firstName;
	private String lastName;
	private String passengerGender;
	private Integer passengerAge;
	private String dateOfJourney;
	private String to;
	private String from;
	private String coachType;
}
