package com.shah.microservices.currencyexchangeservice.rest;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shah.microservices.currencyexchangeservice.modal.CurrencyExchange;
import com.shah.microservices.currencyexchangeservice.service.CurrencyExchangeService;

@RestController
@RequestMapping("/api")
public class CurrencyExchangeController {

	@Autowired
	private Environment env;

	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveCurrencyExchange(@PathVariable String from, @PathVariable String to) {
		String port = env.getProperty("local.server.port");
		CurrencyExchange currencyExchange = currencyExchangeService.retriveCurrencyExchange(from, to);
		if (Objects.isNull(currencyExchange)) {
			throw new RuntimeException("unable to find exchange rate for " + from + " to " + to);
		}
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
}
