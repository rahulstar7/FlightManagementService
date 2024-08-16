package com.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.userservice.model.Adminstrator;

@Repository
public interface AdminRepository extends JpaRepository<Adminstrator, Integer> {

	@Query(value = "select * from admin where name=:name and password=:password ", nativeQuery = true)
	public Adminstrator validateAdmin(@Param("name") String name, @Param("password") String password);

}
