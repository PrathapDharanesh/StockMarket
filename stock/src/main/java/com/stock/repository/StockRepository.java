package com.stock.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stock.pojo.Stock;

@Repository
public interface StockRepository extends MongoRepository<Stock, Long>{
	
	
	 public List<Stock> findByCompanyCode(String companyCode);
	 
}