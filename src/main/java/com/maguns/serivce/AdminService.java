package com.maguns.serivce;


import com.maguns.pojo.AdminPojo;


public interface AdminService {
	
	public AdminPojo saveAdmin(AdminPojo adminPojo);
	
	public AdminPojo findbyusernamepassword(String username,String password);
	
	

}
