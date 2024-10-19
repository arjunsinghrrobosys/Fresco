package com.fresco.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fresco.pojo.Category;
import com.fresco.service.CategoryCourseService;

import jakarta.annotation.PostConstruct;

@RestController
public class CourseController {
	
	private CategoryCourseService categoryCourseService;
	private List<Category> categories;
	
	@PostConstruct
	public void loadData() {
			categories=new ArrayList(Arrays.asList(
			new Category (1001, "cloud Conputing", "network of remote servers hosted on the neu Category"),
			new Category (1002,"Data Science","practice of deriving valunble insights fron new Category"),
			new Category (1003,"Devops","practices that emphasize on collaboration and comm unication"),
			new Category (1804,"Digital Foundation","foundation of the Digital Courses")));
	
	
	
	@RequestMapping("/categories")
	public List<Category> getAllCategories(){
		return categoryCourseService.getAllCategories();
	}
	
	@RequestMapping("categories/{id}")
	public Optional<Category> getCategory(@PathVariable int id ) {
		return categoryCourseService.getCategory(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/categories")
	public void addCategory(@RequestBody Category category){
			categoryCourseService.addCategory(category);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/categories/{id}")
	public void updateCategory(@RequestBody Category category,@PathVariable int id ){
			categoryCourseService.upatdeCategory(category,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/categories/{id}")
	public void deleteCategory(@PathVariable int id) {
		 categoryCourseService.deleteCategory(id);
	}

}
