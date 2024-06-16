package com.maguns.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maguns.pojo.AdminPojo;
import com.maguns.repository.AdminRepository;


@Service
public class AdminServiceIMP1 implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	public AdminPojo saveAdmin(AdminPojo adminPojo) {
		
		return adminRepository.save(adminPojo);
	}
	
	@Override
	public AdminPojo findbyusernamepassword(String username,String password) {
		AdminPojo adminPojo=adminRepository.findbyusernamepassword(username, password);
		return adminPojo;
	}
	

}
