package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Slider;


@Repository
public interface SliderRepository extends JpaRepository<Slider, Integer>{

	@Query("SELECT e from Slider e WHERE e.isOnHomePage=true")
	List<Slider> findByIsOnHomePage(PageRequest pageRequest);
	
	@Query("SELECT e from Slider e WHERE e.activeSlider=true")
	List<Slider> findByActiveSlider(PageRequest pageRequest);
	
}
