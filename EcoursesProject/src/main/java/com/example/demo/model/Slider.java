package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Slider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private String urlLink;
	private String image;
	private boolean isOnHomePage;
	private boolean activeSlider;
	
	public Slider(){
		
	}

	public Slider(int id, String title, String description, String urlLink, String image, boolean isOnHomePage, boolean activeSlider) {
		
		this.id = id;
		this.title = title;
		this.description = description;
		this.urlLink = urlLink;
		this.image = image;
		this.isOnHomePage = isOnHomePage;
		this.activeSlider = activeSlider;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlLink() {
		return urlLink;
	}

	public void setUrlLink(String urlLink) {
		this.urlLink = urlLink;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean getIsOnHomePage() {
		return isOnHomePage;
	}

	public void setIsOnHomePage(boolean isOnHomePage) {
		this.isOnHomePage = isOnHomePage;
	}

	
	public boolean getActiveSlider() {
		return activeSlider;
	}

	public void setActiveSlider(boolean activeSlider) {
		this.activeSlider = activeSlider;
	}

	public void setOnHomePage(boolean isOnHomePage) {
		this.isOnHomePage = isOnHomePage;
	}

	@Override
	public String toString() {
		
		return id+"-"+title;
	}
	

}
