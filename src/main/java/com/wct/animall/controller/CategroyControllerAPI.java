package com.wct.animall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wct.animall.converter.CategoryConverter;
import com.wct.animall.dto.CategoryDto;
import com.wct.animall.dto.CategorySaveDto;
import com.wct.animall.dto.CategoryUpdateDto;
import com.wct.animall.model.Category;
import com.wct.animall.repository.CategoryRepository;
import com.wct.animall.service.CategoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CategroyControllerAPI {

	@Autowired
	CategoryConverter converter;

	@Autowired
	CategoryService categService;

	@Autowired
	CategoryRepository categRepo;

	@GetMapping("/category")
	public List<CategoryDto> GetAll() {
		return categService.findAll();
	}

	@GetMapping("/category/{id}")
	public CategoryDto findByID(@PathVariable Long id) {
		Category category = categService.findById(id);
		return converter.convertToDto(category);
	}

	// ????? why not categorySaveDto
	@PostMapping("/category/add")
	public CategorySaveDto saveCategoryDto(CategorySaveDto dto) throws Exception {
		return categService.saveCategoryDto(dto);
	}

	@RequestMapping(value = "/category/delete/{id}", method = RequestMethod.DELETE)
	public void deleteCategory(Long id) {
		categService.RemoveCategory(id);
	}

	@PutMapping("/category/update/{id}")
	public CategoryUpdateDto updatCategory(@PathVariable("id") Long id,
			@org.springframework.web.bind.annotation.RequestBody CategoryUpdateDto dto) {
		return categService.updateCategoryDto(id, dto);
	}

	// ConcurrentMap<Long, Category> categories = new ConcurrentHashMap<>();
	// POST
//	@PostMapping(value = "/category/add")
//	public Category addCategory(@RequestBody Category category) {
//		categories.put(category.getId(), category);
//		return category;
//	}
	// get all Categories
//	@RequestMapping(value = "/Categories", method = RequestMethod.GET)
//	public List<Category> APIgetCategories() {
//		return categoryService.getAllCategories();
//	}

	// get a Category by id
//	@RequestMapping(value = "/Category/{id}", method = RequestMethod.GET)
//	public Category getSingleCategory(@PathVariable int id) {
//		return categoryService.getSignleCategory(id);
//	}

// save
//	@RequestMapping(value = "/Category/save", method = RequestMethod.POST)
//	public void saveCategory(Category category) {
//		categoryService.saveCategory(category);
//	}

//	@RequestMapping(value = "/Category/update", method = RequestMethod.PUT)
//	public void updateCategory(@RequestBody Category category) {
//		categoryService.updateCategory(category);
//	}

//	@RequestMapping(value = "/Category/delete", method = RequestMethod.DELETE)
//	public void deleteCategory(int id) {
//		categoryService.deleteCategory(id);
//	}

}
