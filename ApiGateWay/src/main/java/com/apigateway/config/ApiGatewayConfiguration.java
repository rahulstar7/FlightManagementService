package com.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder)
	{
		return builder.routes()
				.route(p->p.path("/adminlogin/user/**").uri("lb://UserService"))
				.route(p->p.path("/tavellerservice/user-login/**").uri("lb://tavellerservice"))
				.build();
	}
	
	//http://localhost:8686/ADMINLOGIN/adminlogin/user/RAHUL/password/RATHOD
	//http://localhost:8686/tavellerservice/user-login/name/RAHUL/password/RATHOD
	
}
