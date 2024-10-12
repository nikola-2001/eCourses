package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Teachers;




@Service
public class TeachersService {
	
	@Autowired
	private TeachersRepository repository;


	public void saveTeacher(Teachers teacher) {
		
		
		repository.save(teacher);
	}
	
	public List<Teachers> getTeachers() {
		
        return repository.findAll();
    }
	

	public List<Teachers> getTeachersByVisiable(){
		
		PageRequest pageRequest = PageRequest.of(0, 8, Sort.by(Sort.Direction.ASC ,"id"));
		
		return repository.findByVisiable(pageRequest);
	}
	
public void deleteTeacher(int id) {
		
	repository.deleteById(id);
		
	}

public Teachers getTeacher(int id) {
	
	return repository.getById(id);
	
}
	
}
