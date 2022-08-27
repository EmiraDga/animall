package com.wct.animall.dto;

public class CategoryDto {

	private Long id;
	private String nameCategory;

	private AnimalDto animalDto;

	public CategoryDto() {
	}

	public CategoryDto(Long id, String nameCategory, AnimalDto animalDto) {
		super();
		this.id = id;
		this.nameCategory = nameCategory;
		this.animalDto = animalDto;
	}

	public AnimalDto getAnimalDto() {
		return animalDto;
	}

	public void setAnimalDto(AnimalDto animalDto) {
		this.animalDto = animalDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

}
