package com.wct.animall.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wct.animall.dto.CategoryDto;
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

}
