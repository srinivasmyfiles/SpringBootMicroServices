package com.vj.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vj.entity.StockPrice;

public interface StockPriceRepository extends JpaRepository<StockPrice, Serializable>{

	public StockPrice findByCompanyName(String companyName);

}
