package com.vj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vj.entity.StockPrice;
import com.vj.exceptions.CompanyNotFoundException;
import com.vj.repo.StockPriceRepository;

@Service
public class StockPriceServiceImpl implements StockPriceService {

	@Autowired
	StockPriceRepository stockPriceRepo;

	@Override
	public Double getPriceOfCompany(String companyName) {
		StockPrice stockPrice = stockPriceRepo.findByCompanyName(companyName);
		if (stockPrice == null)
			throw new CompanyNotFoundException("Company Not Found");
		return stockPrice.getStockPrice();
	}

}
