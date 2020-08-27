package com.vj.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vj.service.StockPriceService;

@RestController
@RequestMapping(value = "/price")
public class StockPriceRestController {

	@Autowired
	StockPriceService stockPriceService;

	@GetMapping(value = "/getprice/{company}")
	public ResponseEntity<Double> getPriceOfCompany(@PathVariable("company") String companyName) {
		return new ResponseEntity<Double>(stockPriceService.getPriceOfCompany(companyName), HttpStatus.OK);
	}
}
