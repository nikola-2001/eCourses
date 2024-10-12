package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Testimonials;

@Service
public class TestimonialsService {
	
	@Autowired
	TestimonialsRepository repository;
	
	public List<Testimonials> getTestimonials(){
		return repository.findAll();
	}
	
	
	public void saveTestimonial(Testimonials testimonial) {
		repository.save(testimonial);
	}
	
	public Testimonials getTestimonial(int id) {
		return repository.getById(id);
	}

	public void deleteTestimonial(int id) {
		repository.deleteById(id);
	}

}
