package com.stockmarket.apigateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

	@RequestMapping("/stockFallBack")
    public Mono<String> orderServiceFallBack() {
        return Mono.just("Stock Service is taking too long to respond or is down. Please try again later");
    }
    @RequestMapping("/companyFallback")
    public Mono<String> paymentServiceFallBack() {
        return Mono.just("Company Service is taking too long to respond or is down. Please try again later");
    }
}
