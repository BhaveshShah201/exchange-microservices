package com.shah.microservices.currencyexchangeservice.service;

import com.shah.microservices.currencyexchangeservice.modal.CurrencyExchange;

public interface CurrencyExchangeService {

	CurrencyExchange retriveCurrencyExchange(String from, String to);
}
