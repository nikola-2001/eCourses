package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Teachers;


@Repository
public interface TeachersRepository extends JpaRepository<Teachers, Integer>{

	
	@Query("SELECT e from Teachers e WHERE e.visiable=true")
	List<Teachers> findByVisiable(PageRequest pageRequest);
	
}
