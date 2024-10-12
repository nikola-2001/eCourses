package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Contact;



@Service
public class ContactService {

	@Autowired
	ContactRepository repository;
	
	public List<Contact> getContacts(){
		return repository.findAll();
	}
	
	
	public void saveContact(Contact contact) {
		repository.save(contact);
	}
	
	public Contact getContact(int id) {
		return repository.getById(id);
	}

	public void deleteContact(int id) {
		repository.deleteById(id);
	}
	
	public int countUnreadContacts() {
		return repository.countByViewed(false);
	}
	
	public int countViewedContacts() {
		
		return repository.countByViewed(true);
	}
	
}
