package com.wct.animall.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wct.animall.model.Category;
import com.wct.animall.repository.CategoryRepository;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/categories")
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	@GetMapping("/Category/{id}")
	public Category getSingleCategory(@PathVariable Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		return null;

	}

	// Save the category with its new changes
	@RequestMapping(value = "/Category/update")
	public void saveTheUser(@RequestBody Category category) {
		categoryRepository.save(category);
	}

	// update the category
	@RequestMapping(value = "/categories/save")
	public Category addCategory(@RequestBody Category c) {
		categoryRepository.save(c);
		return c;

	}

	// Remove
	@RequestMapping(value = "/categories/remove/{id}")
	public void RemoveCategory(@PathVariable Long id) {
		categoryRepository.deleteById(id);
	}

}
