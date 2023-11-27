package com.shah.microservices.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayRoutingConfiguration {

    @Bean
    RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes().route(p -> p.path("/get").uri("http://httpbin.org:80"))
				.route(p -> p.path("/api/currency-conversion/**").uri("lb://currency-conversion"))
				.route(p -> p.path("/api/currency-exchange/**").uri("lb://currency-exchange")).build();
	}
}
