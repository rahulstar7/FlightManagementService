package com.flightservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FlightserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightserviceApplication.class, args);
		System.out.println("Flight service is up and running...");

	}

}
