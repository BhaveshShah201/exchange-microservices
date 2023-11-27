package com.shah.microservices.currencyexchangeservice.rest;

import java.math.BigDecimal;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shah.microservices.currencyexchangeservice.modal.CurrencyExchange;
import com.shah.microservices.currencyexchangeservice.service.CurrencyExchangeService;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/api")
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

	@Autowired
	private Environment env;

	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@CircuitBreaker(name = "currency-exchange", fallbackMethod = "defaultCurrencyExchange")
	@RateLimiter(name = "currency-exchange")
	@Bulkhead(name = "currency-exchange")
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveCurrencyExchange(@PathVariable String from, @PathVariable String to) {
		logger.info("retriveCurrencyExchange request from {} to {}", from, to);
		String port = env.getProperty("local.server.port");
		CurrencyExchange currencyExchange = currencyExchangeService.retriveCurrencyExchange(from, to);
		if (Objects.isNull(currencyExchange)) {
			throw new RuntimeException("unable to find exchange rate for " + from + " to " + to);
		}
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}

	public CurrencyExchange defaultCurrencyExchange(String from, String to, Exception ex) {
		BigDecimal multiple = BigDecimal.valueOf(50);
		return new CurrencyExchange(1L, from, to, multiple, env.getProperty("local.server.port"));
	}
}
