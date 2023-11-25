package com.shah.microservices.currencyconversionservice.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shah.microservices.currencyconversionservice.modal.CurrencyConversion;

@FeignClient(name = "currency-exchange", url = "localhost:8000")
public interface CurrencyExchangeProxy {

	@GetMapping("/api/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retriveCurrencyExchange(@PathVariable("from") String from, @PathVariable("to") String to);
}
