package com.wct.animall.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wct.animall.model.Category;
import com.wct.animall.repository.CategoryRepository;

@Service
public class CategoryService {

	private List<Category> category = new ArrayList<>();

	/*******
	 * Using JpaRepository methods
	 **************************/

	@Autowired
	private CategoryRepository CategoryRepo;

// Return all Categories
	public List<Category> getAllCategories() {
		CategoryRepo.findAll().forEach(category::add);
		return category;
	}

// Return Single Category
	public Category getOnlySingleUser(Long id) {
		Optional<Category> optionalCategory = CategoryRepo.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		return null;

	}

// Save the category with its new changes
	public void saveTheUser(Category category) {
		CategoryRepo.save(category);
	}

// update the category 
	public void updateTheUser(Category c) {

		CategoryRepo.save(c);

	}

//Remove
	public void RemoveCategory(Long id) {
		CategoryRepo.deleteById(id);
	}

}
