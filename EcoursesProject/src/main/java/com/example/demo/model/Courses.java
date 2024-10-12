package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Courses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String image;
	private int students;
	private String duration;
	private String rating;
	private String price;
	private boolean isOnHomePage;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	
	public Courses() {
		
	}


	public Courses(int id, String name, String image, int students, String duration, String rating, String price,
			boolean isOnHomePage, Category category) {
		
		this.id = id;
		this.name = name;
		this.image = image;
		this.students = students;
		this.duration = duration;
		this.rating = rating;
		this.price = price;
		this.isOnHomePage = isOnHomePage;
		this.category = category;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getStudents() {
		return students;
	}


	public void setStudents(int students) {
		this.students = students;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public boolean getIsOnHomePage() {
		return isOnHomePage;
	}


	public void setIsOnHomePage(boolean isOnHomePage) {
		this.isOnHomePage = isOnHomePage;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		
		return id+"-"+name;
	}
	
	

}
