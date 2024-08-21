package com.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.userservice.model.Traveller;
import com.userservice.repository.TravellerRepository;

@Service
public class TravellerService {

	@Autowired
	private TravellerRepository repository;

	public String saveTraveller(Traveller traveller) {
		if (!ObjectUtils.isEmpty(traveller)) {
			repository.save(traveller);

			return traveller.getId() + " traveller is saved succesfully";
		} else {
			return traveller.getId() + " traveller is not saved succesfully";
		}
	}

	public String login(String name, String password) {
			Traveller validateTraveler = repository.validateTraveler(name, password);
			if(!ObjectUtils.isEmpty(validateTraveler))
			{
			return "Login succesfully";
		} 
			else {
			return "Login failed please try again";
		}
	}

}
