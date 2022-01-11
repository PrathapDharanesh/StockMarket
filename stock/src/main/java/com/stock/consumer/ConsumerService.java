package com.stock.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock.config.MessagingConfig;
import com.stock.pojo.Stock;
import com.stock.repository.StockRepository;

@Component
public class ConsumerService {

	@Autowired
	StockRepository stockRepository;
	
    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(Stock stock) {
    	 stockRepository.save(stock);
    	 System.out.println(stock);
    }
}