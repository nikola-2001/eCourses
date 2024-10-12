package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.model.Category;
import com.example.demo.model.Contact;
import com.example.demo.model.Courses;
import com.example.demo.model.Registration;
import com.example.demo.model.Slider;
import com.example.demo.model.Teachers;
import com.example.demo.model.Testimonials;
import com.example.demo.repository.CategoryService;
import com.example.demo.repository.ContactService;
import com.example.demo.repository.CoursesService;
import com.example.demo.repository.RegistrationService;
import com.example.demo.repository.SliderService;
import com.example.demo.repository.TeachersService;
import com.example.demo.repository.TestimonialsService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
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
	
//-----------------------------------------------REGISTRATIONS---------------------------------------------------------------------
	
	
		@GetMapping("/registrations")
		public String getRegistrations(Model model) {
			
			model.addAttribute("registrations", registrationService.getRegistrations());
			model.addAttribute("countRegistrations", registrationService.countUnreadRegistrations());
			model.addAttribute("countContacts", contactService.countUnreadContacts());
			
			return "admin/registrations";
		}
		
		@GetMapping("/registration-update")
		public String getRegistrationUpdate(@RequestParam int id) {
			
			Registration registration  = registrationService.getRegistration(id);
			
			registration.setViewed(true);
			
			registrationService.saveRegistration(registration);
			
			return "redirect:/admin/registrations";
		}
		
//-----------------------------------------------TESTIMONIALS------------------------------------------------------------------
		
		@GetMapping("/testimonials")
		public String getTestimonials(Model model) {
			model.addAttribute("testimonials", testimonialsService.getTestimonials());
			model.addAttribute("countRegistrations", registrationService.countUnreadRegistrations());
			model.addAttribute("countContacts", contactService.countUnreadContacts());
			
			return "admin/testimonials";
		}

		

		@GetMapping("/testimonial-delete")
		public String getDeleteTestimonial(@RequestParam int id) {
			
			
			testimonialsService.deleteTestimonial(id);
			
			
			return "redirect:/admin/testimonials";
		}
		
		
		@GetMapping("/testimonial-form")
		public String getTestimonialForm(Testimonials testimonial, Model model) {
			
			model.addAttribute("testimonial", new Testimonials());
			model.addAttribute("countContacts", contactService.countUnreadContacts());
			model.addAttribute("countRegistrations", registrationService.countUnreadRegistrations());
			
			
			
			return "admin/testimonial-form";
		}
		
		@PostMapping("/testimonial-form")
		public String getValidateTestimonialForm(@Valid Testimonials testimonial, BindingResult result) {
			
			if(result.hasErrors()){
				
				return "admin/testimonial-form";		
			}
			
		testimonialsService.saveTestimonial(testimonial);
			
			return "redirect:/admin/testimonials";
		}
		
		
		@GetMapping("/testimonial-update")
		public String getTestimonialUpdateForm(@RequestParam int id, Model model) {
			
			
			
			model.addAttribute("testimonial", testimonialsService.getTestimonial(id));
			model.addAttribute("countRegistrations", registrationService.countUnreadRegistrations());
			model.addAttribute("countContacts", contactService.countUnreadContacts());
		
			
			return "admin/testimonial-form";
		}
		
		

//-----------------------------------------------TEACHERS--------------------------------------------------------------------
		
		
		@GetMapping("/teachers")
		public String getTeachers(Model model) {
			model.addAttribute("teachers", teachersService.getTeachers());
			model.addAttribute("countRegistrations", registrationService.countUnreadRegistrations());
			model.addAttribute("countContacts", contactService.countUnreadContacts());
			
			return "admin/teachers";
		}
		
		@GetMapping("/teacher-delete")
		public String getDeleteTeacher(@RequestParam int id) {
			
			
			teachersService.deleteTeacher(id);
			
			
			return "redirect:/admin/teachers";
		}
		
		@GetMapping("/teacher-form")
		public String getTeacherForm(Teachers teacher, Model model) {
			
			
			model.addAttribute("teacher", new Teachers());
			model.addAttribute("countRegistrations", registrationService.countUnreadRegistrations());
			model.addAttribute("countContacts", contactService.countUnreadContacts());
			
			return "admin/teacher-form";
		}
		
		@PostMapping("/teacher-form")
		public String getValidateTeacherForm(@Valid Teachers teacher, BindingResult result) {
			
			if(result.hasErrors()){
				
				return "admin/teacher-form";		
			}
			
			teachersService.saveTeacher(teacher);
			
			return "redirect:/admin/teachers";
		}
		
		@GetMapping("/teacher-update")
		public String getTeacherUpdateForm(@RequestParam int id, Model model) {
			
			
			
			model.addAttribute("teacher", teachersService.getTeacher(id));
			model.addAttribute("countRegistrations", registrationService.countUnreadRegistrations());
			model.addAttribute("countContacts", contactService.countUnreadContacts());
			
			return "admin/teacher-form";
		}
	
		
//-----------------------------------------------CONTACTS--------------------------------------------------------------------
		
		
			@GetMapping("/contacts")
			public String getContacts(Model model) {
				
				model.addAttribute("contacts", contactService.getContacts());
				model.addAttribute("countRegistrations", registrationService.countUnreadRegistrations());
				model.addAttribute("countContacts", contactService.countUnreadContacts());
				
				
				return "admin/contact";
			}
			
			@GetMapping("/contact-update")
			public String getContactUpdate(@RequestParam int id) {
				
				Contact contact  = contactService.getContact(id);
				
				contact.setViewed(true);
				
				contactService.saveContact(contact);
				
				return "redirect:/admin/contacts";
			}
			
//-----------------------------------------------SLIDERS--------------------------------------------------------------------
			
			
			@GetMapping("/sliders")
			public String getSliders(Model model) {
				model.addAttribute("sliders", sliderService.getSliders());
				model.addAttribute("countRegistrations", registrationService.countUnreadRegistrations());
				model.addAttribute("countContacts", contactService.countUnreadContacts());
				
				return "admin/sliders";
			}
			
			@GetMapping("/slider-delete")
			public String getDeleteSlider(@RequestParam int id) {
				
				
				sliderService.deleteSlider(id);
				
				
				return "redirect:/admin/sliders";
			}
			
			@GetMapping("/slider-form")
			public String getSliderForm(Slider slider, Model model) {
				
				model.addAttribute("countRegistrations", registrationService.countUnreadRegistrations());
				model.addAttribute("countContacts", contactService.countUnreadContacts());
				
				return "admin/slider-form";
			}
			
			@PostMapping("slider-form")
			public String getValidateSliderForm(@Valid Slider slider, BindingResult result) {
				
				if(result.hasErrors()){
					
					return "admin/slider-form";		
				}
				
			sliderService.saveSlider(slider);
				
				return "redirect:/admin/sliders";
			}
			
			@GetMapping("/slider-update")
			public String getSliderUpdateForm(@RequestParam int id, Model model) {
				
				
				
				model.addAttribute("slider", sliderService.getSlider(id));
				model.addAttribute("countRegistrations", registrationService.countUnreadRegistrations());
				model.addAttribute("countContacts", contactService.countUnreadContacts());
				
				return "admin/slider-form";
			}			

//------------------------------------------------------- CATEGORY ------------------------------------------------------------
			@GetMapping("/categories")
			public String getCategories(Model model) {
				
				model.addAttribute("categories", categoryService.getCategories());
				model.addAttribute("countRegistrations", registrationService.countUnreadRegistrations());
				model.addAttribute("countContacts", contactService.countUnreadContacts());

				return "admin/categories";
			}
			
			
			@GetMapping("/category-form")
			public String getCategoryForm(Category category,Model model) {
				
				model.addAttribute("countRegistrations", registrationService.countUnreadRegistrations());
				model.addAttribute("countContacts", contactService.countUnreadContacts());

				
				return "admin/category-form";
			}
			
			@PostMapping("/category-form")
			public String getValidateCategoryForm(@Valid Category category,BindingResult result) {
				
				if(result.hasErrors()) {
					return "admin/category-form";
				}
				
				categoryService.saveCategory(category);
				
				return "redirect:/admin/categories";
			}
			
			@GetMapping("/category-update")
			public String getCategoryUpdateForm(@RequestParam int id,Model model) {
						
				model.addAttribute("category", categoryService.getCategory(id));
				model.addAttribute("countRegistrations", registrationService.countUnreadRegistrations());
				model.addAttribute("countContacts", contactService.countUnreadContacts());

				return "admin/category-form";
			}
			
			@GetMapping("/category-delete")
			public String getCategoryDelete(@RequestParam int id) {
				
				categoryService.deleteCategory(id);
				
				return "redirect:/admin/categories";
				
			}			
			
//----------------------------------------------------------------COURSES------------------------------------------------------
			
			@GetMapping("/courses")
			public String getCourses(Model model) {
				model.addAttribute("courses", coursesService.getCourses());
				model.addAttribute("countRegistrations", registrationService.countUnreadRegistrations());
				model.addAttribute("countContacts", contactService.countUnreadContacts());

				return "admin/courses";
			}
			
			@GetMapping("/course-delete")
			public String getCourseDelete(@RequestParam int id) {
				coursesService.deleteCourse(id);
				
				return "redirect:/admin/courses";
			}
			
			@GetMapping("/course-form")
			public String getCourseForm(Courses course, Model model) {
				
				model.addAttribute("course", new Courses());
				model.addAttribute("categories", categoryService.getCategories());
				model.addAttribute("countRegistrations", registrationService.countUnreadRegistrations());
				model.addAttribute("countContacts", contactService.countUnreadContacts());

				
				return "admin/course-form";
			}
			
			@PostMapping("/course-form")
			public String getValidateCourseForm(@Valid Courses course,BindingResult result) {
				
				if(result.hasErrors()) {
					return "admin/course-form";
				}
				
				coursesService.saveCourse(course);
				
				return "redirect:/admin/courses";
			}
			
			@GetMapping("/course-update")
			public String getCourseUpdateForm(@RequestParam int id,Model model) {
						
				model.addAttribute("course", coursesService.getCourse(id));
				model.addAttribute("categories", categoryService.getCategories());
				model.addAttribute("countRegistrations", registrationService.countUnreadRegistrations());
				model.addAttribute("countContacts", contactService.countUnreadContacts());

				
				return "admin/course-form";
			}
			
			
}
