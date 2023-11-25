package com.shah.microservices.limitservice.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shah.microservices.limitservice.modal.Limits;

@RestController
@RequestMapping("/api")
public class LimitController {

	@GetMapping("/limits")
	public Limits retreiveLimits() {
		return new Limits(1, 100);
	}
}
