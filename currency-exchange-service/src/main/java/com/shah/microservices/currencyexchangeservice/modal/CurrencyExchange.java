package com.shah.microservices.currencyexchangeservice.modal;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CurrencyExchange {

	@Id
	private Long id;

	@Column(name = "currency_from")
	private String from;

	@Column(name = "currency_to")
	private String to;

	private BigDecimal currencyMultiplier;

	private String environment;

	public CurrencyExchange() {
		super();
	}

	public CurrencyExchange(Long id, String from, String to, BigDecimal currencyMultiplier, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.currencyMultiplier = currencyMultiplier;
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

	public BigDecimal getCurrencyMultiplier() {
		return currencyMultiplier;
	}

	public void setCurrencyMultiplier(BigDecimal currencyMultiplier) {
		this.currencyMultiplier = currencyMultiplier;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}
}
