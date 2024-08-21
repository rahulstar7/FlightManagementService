package com.ticket.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "UserService",url="localhost:8686")
public interface UserClient {

	
	
	@GetMapping(value = "/tavellerservice/getMessage")
	public String getUserMsg();
	

	
}
