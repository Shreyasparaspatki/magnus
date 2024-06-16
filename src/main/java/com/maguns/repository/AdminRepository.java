package com.maguns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maguns.pojo.AdminPojo;


public interface AdminRepository extends JpaRepository<AdminPojo,Integer>{
	
	@Query("from AdminPojo where username = :username and password =:password")
	public AdminPojo findbyusernamepassword(@Param("username") String username, @Param("password") String password);

}
