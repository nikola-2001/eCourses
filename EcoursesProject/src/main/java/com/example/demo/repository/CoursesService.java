package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Courses;




@Service
public class CoursesService {
	
	@Autowired
	private CoursesRepository repository;
	
	public List<Courses> getCourses(){
		return repository.findAll();
	}

	
	public void saveCourse(Courses course) {
		repository.save(course);
	}
	
	public Courses getCourse(int id) {
		return repository.getById(id);
	}
	
	public void deleteCourse(int id) {
		repository.deleteById(id);
	}
	
	
	public List<Courses> getCoursesByCategory(int categoryId){
		return repository.findByCategoryId(categoryId);
	}
	

	public List<Courses> getCoursesOnHomePage(){
		
		PageRequest pageRequest = PageRequest.of(0, 6,Sort.by(Sort.Direction.ASC ,"id"));
		
		return repository.findByIsOnHomePage(pageRequest);
	}

}
