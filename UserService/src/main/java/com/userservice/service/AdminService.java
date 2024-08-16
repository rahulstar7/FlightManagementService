package com.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.userservice.model.Adminstrator;
import com.userservice.repository.AdminRepository;

@Service
public class AdminService {

	
	@Autowired
	private AdminRepository repository;
	
	
	
	public String validateAdmin(String name , String password)
	{
		Adminstrator validateAdmin = repository.validateAdmin(name, password);
		if(!ObjectUtils.isEmpty(validateAdmin))
		{
			return "Login successfully";
		}
		return "Login failed please login with valid credentials";
	}
	
	public Adminstrator createAdmin(Adminstrator adminstrator)
	{
		
		return repository.save(adminstrator);
		
	}
}
