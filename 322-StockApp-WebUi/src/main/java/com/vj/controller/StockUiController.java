package com.vj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vj.service.StockUiService;

@Controller
public class StockUiController {

	@Autowired
	StockUiService stockUiService;
	
	@GetMapping("/")
	public String loadForm() {
		return "index";
	}
	
	@GetMapping("/getTotalCost")
	public String getTotalCost(HttpServletRequest req,Model model) {
		String companyName = req.getParameter("companyName");
		String qtty=req.getParameter("quantity");
		String totalStockCost = stockUiService.getStockPriceTotal(companyName, Integer.parseInt(qtty));
		model.addAttribute("total", totalStockCost);
		return "index";
	}
}
