package com.shah.microservices.currencyexchangeservice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shah.microservices.currencyexchangeservice.modal.CurrencyExchange;
import com.shah.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.shah.microservices.currencyexchangeservice.service.CurrencyExchangeService;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	@Override
	public CurrencyExchange retriveCurrencyExchange(String from, String to) {
		return currencyExchangeRepository.findByFromAndTo(from, to);
	}

}
