package com.stock.service;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.stock.config.MessagingConfig;
import com.stock.pojo.Stock;
import com.stock.repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	StockRepository stockRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
    @Autowired
    private RabbitTemplate template;
    
    @Autowired
	private MongoTemplate mt;


	public List<Stock> stockDetails(String companyID) {

	//	return stockDetailDao.findByCompanyCode(companyID);

		return stockRepository.findByCompanyCode(companyID);
	}

	public List<Stock> stockDetailsByDate(Date StartDate, Date EndDate, String CompanyCode) {

		//return stockDetailDao.findByStockDate(StartDate, EndDate, CompanyCode);
		Query query = new Query();
		List<Criteria> criteria = new ArrayList<>();
		criteria.add(Criteria.where("companyCode").is(CompanyCode));
		criteria.add(Criteria.where("stockDate").gte(StartDate).lte(EndDate));
		query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
		
		
		 List<Stock> users = mt.find(query, Stock.class);
				 //MongoTemplate.find(query, Stock.class);
		 return users;

		// query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
		// List<JSONObject> filteredVals = mongoOperations.find(query, JSONObject.class);
	}

	public String stockEntry(String companyID) {

		Random r = new Random();
		Stock stockDetails = new Stock();
		stockDetails.setStockId(sequenceGeneratorService.generateSequence(Stock.SEQUENCE_NAME));
		stockDetails.setCompanyCode(companyID);
		stockDetails.setStockPrice(r.nextDouble()*10);
		stockDetails.setStockDate(LocalDate.now());

		template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, stockDetails);
		//stockRepository.save(stockDetails);
		return "Sent the message to Queue";

	}
}
