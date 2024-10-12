package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.model.Contact;
import com.example.demo.model.Registration;
import com.example.demo.repository.CategoryService;
import com.example.demo.repository.ContactService;
import com.example.demo.repository.CoursesService;
import com.example.demo.repository.RegistrationService;
import com.example.demo.repository.SliderService;
import com.example.demo.repository.TeachersService;
import com.example.demo.repository.TestimonialsService;

import jakarta.validation.Valid;

@Controller
public class FrontController {

	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private TestimonialsService testimonialsService;
	
	@Autowired
	private TeachersService teachersService;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private SliderService sliderService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CoursesService coursesService;
	
	
	@GetMapping("/home")
	public String getHomePage(Model model) {
		
		model.addAttribute("activeSlider", sliderService.getActiveSlider());
		model.addAttribute("sliders", sliderService.getSlidersOnHomePage());
		model.addAttribute("categories", categoryService.getCategories());
		model.addAttribute("courses", coursesService.getCoursesOnHomePage());
		model.addAttribute("registration", new Registration());
		model.addAttribute("selectCourse", coursesService.getCourses());
		model.addAttribute("teachers", teachersService.getTeachersByVisiable());
		model.addAttribute("testimonials", testimonialsService.getTestimonials());
		
		
		return "front/home";
		
	}
	
	@PostMapping("/home-registration-save")
	public String getValidateHomeRegistrationForm(@Valid Registration registration, BindingResult result) {
		
		if(result.hasErrors()) {
			
			return "redirect:/home";
			
		}

	registrationService.saveRegistration(registration);
		
		return "redirect:/home";
		
		
	}
	
	
	@GetMapping("/about")
	public String getAboutPage(Model model) {
		
		model.addAttribute("registration", new Registration());
		model.addAttribute("testimonials", testimonialsService.getTestimonials());
		model.addAttribute("courses", coursesService.getCourses());

		
		return "front/about";
	}
	
	@PostMapping("/registration-save")
	public String getValidateRegistrationForm(@Valid Registration registration, BindingResult result) {
		
		if(result.hasErrors()) {
			
			return "redirect:/about";
			
		}

	registrationService.saveRegistration(registration);
		
		return "redirect:/about";
		
		
	}
	
	
	@GetMapping("/teachers")
	public String getTeachersPage(Model model) {
		
		model.addAttribute("teachers", teachersService.getTeachersByVisiable());
		
		
		return "front/teachers";
		
	}
	
	@GetMapping("/contact")
	public String getContactPage(Model model) {
		
		model.addAttribute("contact", new Contact());

		
		return "front/contact";
	}
	
	@PostMapping("/contact-save")
	public String getValidateContactForm(@Valid Contact contact, BindingResult result) {
		
		if(result.hasErrors()) {
			
			return "redirect:/contact";
			
		}

		contactService.saveContact(contact);
		
		return "redirect:/contact";
		
		
	}

	
	
	@GetMapping("/courses")
	public String getCoursesPage(Model model,@RequestParam(required = false) Integer category_id) {
		
		model.addAttribute("categories", categoryService.getCategories());

		
		if(category_id!=null) {
			model.addAttribute("courses", coursesService.getCoursesByCategory(category_id));
		}
		
		else {
			model.addAttribute("courses", coursesService.getCoursesOnHomePage());
		}
		
		
		return "front/courses";
	}
	
}
