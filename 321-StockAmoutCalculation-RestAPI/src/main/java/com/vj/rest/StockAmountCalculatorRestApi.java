package com.vj.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vj.client.StockPriceClient;

@RestController
@RequestMapping(value = "/pricecalc")
public class StockAmountCalculatorRestApi {

	@Autowired
	StockPriceClient stockPriceClient;

	@GetMapping(value = "/getTotal/{company}/{qntty}")
	public ResponseEntity<String> getTotalPriceOf(@PathVariable("company") String companyName,
			@PathVariable("qntty") Integer quantity) {
		Double totalStockPrice = null;
		String response = null;

		ResponseEntity<Double> presentStockPrice = stockPriceClient.getStockPriceOf(companyName);
		
		if (presentStockPrice.getStatusCode().value() == 200) {
			Double stockTotPrice = presentStockPrice.getBody();
			totalStockPrice = stockTotPrice * quantity;
			response = "Total Stock Price is : " + totalStockPrice;
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Company Not Found", HttpStatus.BAD_REQUEST);
	}
}
