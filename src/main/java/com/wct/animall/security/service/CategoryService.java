package com.wct.animall.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wct.animall.model.Category;

@Service
public class CategoryService {

	private List<Category> categories = new ArrayList<>();

	// POST
	public void addCategory(Category category) {
		categories.add(category);
	}

	// GET
	public Category getCategory(Long id) {
		return categories.stream().filter(c -> c.getId().equals(id)).findFirst().get();

	}

	// Return all categories
	public List<Category> getAllCategories() {
		return categories;
	}

	// Return Single Category
	public Category getSignleCategory(int id) {
		for (Category c : categories) {
			if (c.getId() == id)
				return c;
		}
		return null;
	}

	// Save the Category with its new changes
	public void saveCategory(Category category) {
		this.categories.add(category);
	}

	// update the category
	public void updateCategory(Category category) {
		for (Category c : categories) {
			if (c.getId() == category.getId()) {
				c.setName(category.getName());
			}
		}

	}

	// Remove an Category
	public void deleteCategory(int id) {
		categories.remove(id);
	}
}
