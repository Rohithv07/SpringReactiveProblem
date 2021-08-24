package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.filter.JwtAuthenticationFilter;


@Configuration
public class GatewayConfig {

	@Autowired
	private JwtAuthenticationFilter filter;

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes().route("auth", r -> r.path("/auth/**").filters(f -> f.filter(filter)).uri("lb://auth"))
				.route("update", r -> r.path("/update/**").filters(f -> f.filter(filter)).uri("lb://update"))
				.route("loan", r -> r.path("/loan/**").filters(f -> f.filter(filter)).uri("lb://loan"))
				.build();
	}
	
//	@Bean
//	public RouteLocator routes(RouteLocatorBuilder builder) {
//		return builder.routes().route("auth", r -> r.path("/auth/**").filters(f -> f.filter(filter)).uri("lb://auth"))
//				.route("alert", r -> r.path("/alert/**").filters(f -> f.filter(filter)).uri("lb://alert"))
//				.route("echo", r -> r.path("/echo/**").filters(f -> f.filter(filter)).uri("lb://echo"))
//				.route("hello", r -> r.path("/hello/**").filters(f -> f.filter(filter)).uri("lb://hello")).build();
//	}


}
