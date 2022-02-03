package com.stock.pojo;



import java.sql.Date;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Stock")
public class Stock {
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private long stockId;
	private Double stockPrice;
	private String companyCode;
	private LocalDate stockDate;
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(long stockId, Double stockPrice, String companyCode, LocalDate stockDate) {
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

	public LocalDate getStockDate() {
		return stockDate;
	}

	public void setStockDate(LocalDate stockDate) {
		this.stockDate = stockDate;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockPrice=" + stockPrice + ", companyCode="
				+ companyCode + ", stockDate=" + stockDate + "]";
	}

	
}
