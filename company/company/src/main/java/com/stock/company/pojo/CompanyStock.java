package com.stock.company.pojo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CompanyStock {

	private Company company;
	
	private List<Stock> stock;

	public CompanyStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyStock(Company company, List<Stock> stock) {
		super();
		this.company = company;
		this.stock = stock;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Stock> getStock() {
		return stock;
	}

	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}
	
	
}
