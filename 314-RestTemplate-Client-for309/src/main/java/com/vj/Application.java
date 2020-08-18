package com.vj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.vj.client.TicketBookingClient;
import com.vj.response.TicketDetails;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(Application.class, args);
		TicketBookingClient ticket = ctxt.getBean(TicketBookingClient.class);
		TicketDetails tckt = ticket.invokeRestApi();
		System.out.println(tckt );
	}

}
