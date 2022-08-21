package com.wct.animall.controller;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wct.animall.model.Category;
import com.wct.animall.security.service.CategoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CategroyControllerAPI {

	ConcurrentMap<Long, Category> categories = new ConcurrentHashMap<>();

	/********************* ADD A categroy ****************/
	// POST
	@PostMapping(value = "/category/add")
	public Category addCategory(@RequestBody Category category) {
		categories.put(category.getId(), category);
		return category;
	}

	/****************** ADD A categroy ********/

	@Autowired
	private CategoryService categoryService;

	/***** GET *****/
	// get all Categories
	@RequestMapping(value = "/Categories", method = RequestMethod.GET)
	public List<Category> APIgetCategories() {
		return categoryService.getAllCategories();
	}

	// get a Category by id
	@RequestMapping(value = "/Category/{id}", method = RequestMethod.GET)
	public Category getSingleCategory(@PathVariable int id) {
		return categoryService.getSignleCategory(id);
	}

	/**** POST ****/
// save
	@RequestMapping(value = "/Category/save", method = RequestMethod.POST)
	public void saveCategory(Category category) {
		categoryService.saveCategory(category);
	}

	/**** PUT ****/
	@RequestMapping(value = "/Category/update", method = RequestMethod.PUT)
	public void updateCategory(@RequestBody Category category) {
		categoryService.updateCategory(category);
	}

	/**** DELETE ****/
	@RequestMapping(value = "/Category/delete", method = RequestMethod.DELETE)
	public void deleteCategory(int id) {
		categoryService.deleteCategory(id);
	}

}
