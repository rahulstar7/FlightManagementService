package com.userservice.admincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.model.Adminstrator;
import com.userservice.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	String msg = "Login with Admin credentials";

	@PostMapping(value = "/createAdmin")
	public Adminstrator createAdmin(@RequestBody Adminstrator adminstrator) {
		return adminService.createAdmin(adminstrator);
	}

	@GetMapping(value = "/adminlogin/user/{name}/password/{password}")
	public ResponseEntity<String> validateAdmin(@PathVariable String name,
			@PathVariable String password) {

		
		msg=adminService.validateAdmin(name, password);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/admin/getMsg")
	public String getMgsAdmin()
	{
		
		return msg;
	}

}
