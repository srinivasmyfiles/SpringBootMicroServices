package com.vj.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STOCK-PRICE-SERVICE")
public interface StockPriceClient {

	@GetMapping(value = "/price/getprice/{company}")
	public ResponseEntity<Double> getStockPriceOf(@PathVariable("company") String companyName);
}
