package com.maguns.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maguns.pojo.ContactPojo;
import com.maguns.repository.ContactRepository;

@Service
public class ContactServiceImp implements ContactSerivce {

	
	@Autowired
	private ContactRepository contactRepository;
	
	
	@Override
	public ContactPojo saveContactPojo(ContactPojo contactPojo) {
		
		return contactRepository.save(contactPojo);
	}
	
	  @Override
	    public List<ContactPojo> getAllContactPojos() {
	        return contactRepository.findAll();
	    }

}
