package com.wct.animall.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wct.animall.dto.CategoryDto;
import com.wct.animall.dto.CategorySaveDto;
import com.wct.animall.dto.CategoryUpdateDto;
import com.wct.animall.model.Category;

@Service
public class CategoryConverter {
	@Autowired
	private ModelMapper modelMapper;

	public CategoryDto convertToDto(Category category) {

		CategoryDto dto = modelMapper.map(category, CategoryDto.class);
		return dto;
	}

	public List<CategoryDto> entityToDto(List<Category> category) {
		return category.stream().map(x -> convertToDto(x)).collect(Collectors.toList());
	}

	public Category convertToEntity(CategoryDto dto) {
		Category category = modelMapper.map(dto, Category.class);
		return category;
	}

	// Save

	public Category convertToEntitySave(CategorySaveDto dto) {
		Category category = modelMapper.map(dto, Category.class);
		return category;
	}

	public CategorySaveDto convertToDtoSave(Category category) {

		CategorySaveDto dto = modelMapper.map(category, CategorySaveDto.class);
		return dto;
	}

	// update

	public Category convertToEntityUpdate(CategoryUpdateDto dto) {
		Category category = modelMapper.map(dto, Category.class);
		return category;
	}

	public CategoryUpdateDto convertToDtoUpdate(Category category) {

		CategoryUpdateDto dto = modelMapper.map(category, CategoryUpdateDto.class);
		return dto;
	}

}
