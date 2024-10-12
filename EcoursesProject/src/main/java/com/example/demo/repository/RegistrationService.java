package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Registration;



@Service
public class RegistrationService {
	
	@Autowired
	RegistrationRepository repository;
	
	public List<Registration> getRegistrations(){
		return repository.findAll();
	}
	
	
	public void saveRegistration(Registration registration) {
		repository.save(registration);
	}
	
	public Registration getRegistration(int id) {
		return repository.getById(id);
	}

	public void deleteRegistration(int id) {
		repository.deleteById(id);
	}
	
	public int countUnreadRegistrations() {
		return repository.countByViewed(false);
	}
	
	public int countViewedRegistrations() {
		
		return repository.countByViewed(true);
	}

}
