package com.wct.animall.dto;

public class CategoryUpdateDto {
	private String nameCategory;

	private AnimalDto AnimalDto;

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public CategoryUpdateDto(String nameCategory, com.wct.animall.dto.AnimalDto animalDto) {
		super();
		this.nameCategory = nameCategory;
		AnimalDto = animalDto;
	}

	public CategoryUpdateDto() {
		super();
	}

	public AnimalDto getAnimalDto() {
		return AnimalDto;
	}

	public void setAnimalDto(AnimalDto animalDto) {
		AnimalDto = animalDto;
	}

}
