package com.wct.animall.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wct.animall.converter.CategoryConverter;
import com.wct.animall.dto.CategoryDto;
import com.wct.animall.model.Category;
import com.wct.animall.repository.CategoryRepository;

@Service
public class CategoryService {

	private List<Category> categories = new ArrayList<>();

	@Autowired
	CategoryConverter converter;

	@Autowired
	private CategoryRepository CatRepo;

	// GET ALL
	public List<CategoryDto> findAll() {
		List<CategoryDto> categoryDtoList = new ArrayList<>();
		CatRepo.findAll().forEach(categroy -> categoryDtoList.add(converter.convertToDto(categroy)));
		return categoryDtoList;
	}

	// Return Single User
	public Category findById(Long id) {
		return CatRepo.findById(id).get();
	}

	public void RemoveCategory(Long id) {
		CatRepo.deleteById(id);
	}

	public CategoryDto saveCategoryDto(CategoryDto dto) {
		Category category = converter.convertToEntity(dto);
		return converter.convertToDto(CatRepo.save(category));
	}

	public CategoryDto updateCategoryDto(Long id, CategoryDto dto) {
		Category SavedCategory = CatRepo.findById(id).get();
		Category CategoryToUpdate = converter.convertToEntity(dto);

		SavedCategory.setName(CategoryToUpdate.getName());

		return converter.convertToDto(CatRepo.save(SavedCategory));
	}

//	// POST
//	public void addCategory(Category category) {
//		categories.add(category);
//	}
//
//	// GET
//	public Category getCategory(Long id) {
//		return categories.stream().filter(c -> c.getId().equals(id)).findFirst().get();
//
//	}
//
//	// Return all categories
//	public List<Category> getAllCategories() {
//		return categories;
//	}
//
//	// Return Single Category
//	public Category getSignleCategory(int id) {
//		for (Category c : categories) {
//			if (c.getId() == id)
//				return c;
//		}
//		return null;
//	}
//
//	// Save the Category with its new changes
//	public void saveCategory(Category category) {
//		this.categories.add(category);
//	}
//
//	// update the category
//	public void updateCategory(Category category) {
//		for (Category c : categories) {
//			if (c.getId() == category.getId()) {
//				c.setName(category.getName());
//			}
//		}
//
//	}
//
//	// Remove an Category
//	public void deleteCategory(int id) {
//		categories.remove(id);
//	}
}
