package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;



@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository repository;
	
	public List<Category> getCategories(){
		return repository.findAll();
	}
	
	public Category getCategory(int id) {
		return repository.getById(id);
	}
	
	public void deleteCategory(int id) {
		repository.deleteById(id);
	}
	
	public void saveCategory(Category category) {
		repository.save(category);
	}

}
