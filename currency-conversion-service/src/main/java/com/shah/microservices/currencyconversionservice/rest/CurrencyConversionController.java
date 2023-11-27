package com.shah.microservices.currencyconversionservice.rest;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shah.microservices.currencyconversionservice.config.CurrencyExchangeProxy;
import com.shah.microservices.currencyconversionservice.modal.CurrencyConversion;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/api")
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy proxy;

	@CircuitBreaker(name = "currency-conversion", fallbackMethod = "defaultCurrencyConversion")
	@RateLimiter(name = "currency-conversion")
	@Bulkhead(name = "currency-conversion")
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversion conversion = proxy.retriveCurrencyExchange(from, to);
		conversion.setQuantity(quantity);
		conversion.setTotalExchangeValue(conversion.getCurrencyMultiplier().multiply(quantity));
		return conversion;
	}

	public CurrencyConversion defaultCurrencyConversion(String from, String to, BigDecimal quantity, Exception ex) {
		BigDecimal multiple = BigDecimal.valueOf(50);
		return new CurrencyConversion(1L, from, to, quantity, multiple, quantity.multiply(multiple), "8000");
	}
}
