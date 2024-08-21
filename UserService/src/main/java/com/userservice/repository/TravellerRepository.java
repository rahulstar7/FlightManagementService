package com.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.userservice.model.Traveller;

@Repository
public interface TravellerRepository extends JpaRepository<Traveller, Integer> {
	
	
	
	
	
	@Query(value = "select * from traveller where name=:name and password=:password",nativeQuery = true)
	public Traveller validateTraveler(@Param("name") String name ,@Param("password") String password);
	

}
