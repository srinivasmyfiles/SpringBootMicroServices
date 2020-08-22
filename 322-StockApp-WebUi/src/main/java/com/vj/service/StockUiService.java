package com.vj.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StockUiService {

	private static final String END_POINT_URL = "http://localhost:3535/getTotal/{company}/{qntty}";

	public String getStockPriceTotal(String companyName, Integer quantity) {

		WebClient webClient = WebClient.create();
		String response = webClient.get().uri(END_POINT_URL, companyName, quantity).retrieve().bodyToMono(String.class)
				.block();
		return response;
	}
}
