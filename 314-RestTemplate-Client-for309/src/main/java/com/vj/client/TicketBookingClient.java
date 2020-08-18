package com.vj.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vj.request.PassengerDetails;
import com.vj.response.TicketDetails;

@Service
public class TicketBookingClient {
	
	private String REST_ENDPOINT_URL="http://localhost:2525/bookTicket1";
	
	public TicketDetails invokeRestApi() {
		RestTemplate rt=new RestTemplate();

		//In real-time these details will come from UI/form.
		PassengerDetails pDetails=new PassengerDetails();
		pDetails.setCoachType("NON-AC");
		pDetails.setDateOfJourney("13thAug'20");
		pDetails.setFirstName("Vijay");
		pDetails.setFrom("Hyderabad");
		pDetails.setLastName("Muccharla");
		pDetails.setPassengerAge(26);
		pDetails.setPassengerGender("M");
		pDetails.setTo("Chennai");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		
		HttpEntity<PassengerDetails> reqEntity = new HttpEntity<>(pDetails, headers);
		
		ResponseEntity<TicketDetails> ticketDetails = rt.postForEntity(REST_ENDPOINT_URL, reqEntity, TicketDetails.class);
		if(ticketDetails.getStatusCode().value()==200) {
			return ticketDetails.getBody();
		}
		else
			return null;
	}
}
