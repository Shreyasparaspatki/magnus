package com.maguns.serivce;

import java.util.List;

import com.maguns.pojo.ContactPojo;

public interface ContactSerivce  {

	public ContactPojo saveContactPojo(ContactPojo contactPojo);
	List<ContactPojo> getAllContactPojos();
	
}
