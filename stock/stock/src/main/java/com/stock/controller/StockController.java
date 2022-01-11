package com.stock.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stock.pojo.Stock;
import com.stock.service.StockService;

@RestController
public class StockController {

	@Autowired
	StockService stockService;
	
	@PostMapping(value = "/stock/add/{companyID}")
	public String createStockDetails(@PathVariable String companyID) {
		return stockService.stockEntry(companyID);
	}

	@GetMapping(value = "/stock/{CompanyCode}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Stock> getStockDetails(@PathVariable String CompanyCode) {

		return stockService.stockDetails(CompanyCode);
	}

	@GetMapping(value = "/stock/get/")
	public List<Stock> getStockDateDetails(@RequestParam String companyID, @RequestParam Date startDate,
			@RequestParam Date endDate) {
		if (startDate.compareTo(endDate) == 0 || startDate.compareTo(endDate) > 0) {
			
		}
		return stockService.stockDetailsByDate(startDate, endDate, companyID);
	}
}
