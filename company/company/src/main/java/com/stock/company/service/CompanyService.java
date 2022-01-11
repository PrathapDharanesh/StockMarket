package com.stock.company.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stock.company.pojo.Company;
import com.stock.company.pojo.CompanyStock;
import com.stock.company.pojo.Stock;
import com.stock.company.repository.ComapanyRepository;

@Service
public class CompanyService {
	
	private static final String BASE_URL = "http://Stock-Application/stock/";
			//"http://localhost:9001/stock/";

	@Autowired
	ComapanyRepository comapanyRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	public CompanyStock findByCompanyCode(String companyCode) {
		
		CompanyStock CompanyStock = new CompanyStock();
		CompanyStock.setCompany(comapanyRepository.findByCompanyCode(companyCode));
		
		ResponseEntity<Stock[]> responseEntity =
				   restTemplate.getForEntity(BASE_URL+companyCode, Stock[].class);
		Stock[] stock = responseEntity.getBody();
		CompanyStock.setStock(Arrays.asList(stock));
		return CompanyStock;
		//ObjectMapper mapper = new ObjectMapper();
		/*
		 * company.setStock( Arrays.stream(stock)
		 * .map(Stock::getStockId).map(Stock::getCompanyCode)
		 * .collect(Collectors.toList()));
		 * 
		 * return null;
		 *///List<Stock> stockList = restTemplate.get
		//return comapanyRepository.findByCompanyCode(companyCode);
	}
	
	public List<Company> findAll(){
		return comapanyRepository.findAll();
	}
	
	public Company saveCompany(Company company) {
		return comapanyRepository.save(company);
	}
}