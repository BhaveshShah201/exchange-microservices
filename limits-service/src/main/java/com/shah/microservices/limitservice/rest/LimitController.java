package com.shah.microservices.limitservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shah.microservices.limitservice.config.Configuration;
import com.shah.microservices.limitservice.modal.Limits;

@RestController
@RequestMapping("/api")
public class LimitController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public Limits retreiveLimits() {
		return new Limits(configuration.getMinimum(), configuration.getMaximum());
	}
}
