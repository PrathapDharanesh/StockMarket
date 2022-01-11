package com.stock.company.pojo;


import java.util.Date;

import org.springframework.stereotype.Component;


@Component
public class Stock {
	
	private long stockId;
	private Double stockPrice;
	private String companyCode;
	private Date stockDate;
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(long stockId, Double stockPrice, String companyCode, Date stockDate) {
		super();
		this.stockId = stockId;
		this.stockPrice = stockPrice;
		this.companyCode = companyCode;
		this.stockDate = stockDate;
	}

	public long getStockId() {
		return stockId;
	}

	public void setStockId(long l) {
		this.stockId = l;
	}

	public Double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public Date getStockDate() {
		return stockDate;
	}

	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockPrice=" + stockPrice + ", companyCode="
				+ companyCode + ", stockDate=" + stockDate + "]";
	}

	
}
