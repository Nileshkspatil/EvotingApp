package com.evotingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.evotingapp.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
	
	@Query("select l from Login l where l.email=:email")
	public Login getLoginByUserName(@Param("email") String email);

}
