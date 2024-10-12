package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Courses;


@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer>{

	List<Courses> findByCategoryId(int id);
	
	@Query("SELECT e from Courses e WHERE e.isOnHomePage=true")
	List<Courses> findByIsOnHomePage(PageRequest pageRequest);
	
}
