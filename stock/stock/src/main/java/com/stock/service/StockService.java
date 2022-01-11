package com.stock.service;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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


	public List<Stock> stockDetails(String companyID) {

	//	return stockDetailDao.findByCompanyCode(companyID);

		return stockRepository.findByCompanyCode(companyID);
	}

	public List<Stock> stockDetailsByDate(Date StartDate, Date EndDate, String CompanyCode) {

		//return stockDetailDao.findByStockDate(StartDate, EndDate, CompanyCode);
		return null;
	}

	public String stockEntry(String companyID) {

		Random r = new Random();
		Stock stockDetails = new Stock();
		stockDetails.setStockId(sequenceGeneratorService.generateSequence(Stock.SEQUENCE_NAME));
		stockDetails.setCompanyCode(companyID);
		stockDetails.setStockPrice(r.nextDouble()*10);
		java.util.Date date = new java.util.Date();
		stockDetails.setStockDate(new Date(date.getTime()));

		template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, stockDetails);
		
		return "Sent the message to Queue";

	}
}
