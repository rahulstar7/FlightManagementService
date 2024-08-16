package com.flightservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="UserService", url = "localhost:8686")
public interface UserFeignClient {

	@GetMapping(value="/admin/getMsg")
	public String getAdminMsg();
}
