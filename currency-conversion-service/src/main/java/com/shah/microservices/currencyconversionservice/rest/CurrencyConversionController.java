package com.shah.microservices.currencyconversionservice.rest;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shah.microservices.currencyconversionservice.config.CurrencyExchangeProxy;
import com.shah.microservices.currencyconversionservice.modal.CurrencyConversion;

@RestController
@RequestMapping("/api")
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversion conversion = proxy.retriveCurrencyExchange(from, to);
		conversion.setQuantity(quantity);
		conversion.setTotalExchangeValue(conversion.getCurrencyMultiplier().multiply(quantity));
		return conversion;
	}
}
