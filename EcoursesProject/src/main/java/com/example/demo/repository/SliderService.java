package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Slider;



@Service
public class SliderService {

	@Autowired
	SliderRepository repository;
	

	public void saveSlider(Slider slider) {
		
		
		repository.save(slider);
	}
	
	public List<Slider> getSliders() {
		
        return repository.findAll();
    }
	
	public List<Slider> getSlidersOnHomePage(){
		
		PageRequest pageRequest = PageRequest.of(0, 2,Sort.by(Sort.Direction.ASC ,"id"));
		
		return repository.findByIsOnHomePage(pageRequest);
	}
	

	public List<Slider> getActiveSlider(){
		
		PageRequest pageRequest = PageRequest.of(0, 1,Sort.by(Sort.Direction.ASC ,"id"));
		
		return repository.findByActiveSlider(pageRequest);
	}
	

	public void deleteSlider(int id) {
		
	repository.deleteById(id);
		
	}


	public Slider getSlider(int id) {
	
	return repository.getById(id);
	
}
	
}
