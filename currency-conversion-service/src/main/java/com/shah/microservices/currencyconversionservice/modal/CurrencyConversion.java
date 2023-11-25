package com.shah.microservices.currencyconversionservice.modal;

import java.math.BigDecimal;

public class CurrencyConversion {

	private Long id;

	private String from;

	private String to;

	private BigDecimal quantity;
	
	private BigDecimal currencyMultiplier;
	
	private BigDecimal totalExchangeValue;

	private String environment;

	
	
	
	
	public CurrencyConversion(Long id, String from, String to, BigDecimal quantity, BigDecimal currencyMultiplier,
			BigDecimal totalExchangeValue, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.currencyMultiplier = currencyMultiplier;
		this.totalExchangeValue = totalExchangeValue;
		this.environment = environment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getCurrencyMultiplier() {
		return currencyMultiplier;
	}

	public void setCurrencyMultiplier(BigDecimal currencyMultiplier) {
		this.currencyMultiplier = currencyMultiplier;
	}

	public BigDecimal getTotalExchangeValue() {
		return totalExchangeValue;
	}

	public void setTotalExchangeValue(BigDecimal totalExchangeValue) {
		this.totalExchangeValue = totalExchangeValue;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	
}
