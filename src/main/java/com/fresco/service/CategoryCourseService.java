package com.fresco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fresco.pojo.Category;

@Service
public class CategoryCourseService {
	
	
	public List <Category> categories;
	
	public void addCategory(Category category) {
		categories.add(category);
	}
	
	public List<Category> getAllCategories(){
		return categories;
	}
	public Optional<Category> getCategory(int id){
		return categories.stream().filter(c -> c.getId() == id).findFirst();
	}
	
	public void upatdeCategory(Category category , int id){
	for (int i = 0; i < categories.size(); i++) {
		Category c = categories.get(i);
		if (c.getId()==id) {
			categories.set(i, category);
			return;
		}
	}
	}
	public void deleteCategory(int id ) {
		categories.remove(categories.stream().filter(c -> c.getId()==id).findFirst().get());
	}

}
