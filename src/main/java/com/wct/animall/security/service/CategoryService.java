package com.wct.animall.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wct.animall.model.Category;

@Service
public class CategoryService {

	private List<Category> category = new ArrayList<>();
	/*
	 * @Autowired private CategoryRepository CategoryRepo;
	 * 
	 * // Return all Categories public List<Category> getAllCategories() {
	 * CategoryRepo.findAll().forEach(category::add); return category; }
	 * 
	 * // Return Single Category public Category getOnlySingleCategory(Long id) {
	 * Optional<Category> optionalCategory = CategoryRepo.findById(id); if
	 * (optionalCategory.isPresent()) { return optionalCategory.get(); } return
	 * null;
	 * 
	 * }
	 * 
	 * // Save the category with its new changes public void saveTheUser(Category
	 * category) { CategoryRepo.save(category); }
	 * 
	 * // update the category public void updateTheUser(Category c) {
	 * 
	 * CategoryRepo.save(c);
	 * 
	 * }
	 * 
	 * //Remove public void RemoveCategory(Long id) { CategoryRepo.deleteById(id); }
	 */
}
