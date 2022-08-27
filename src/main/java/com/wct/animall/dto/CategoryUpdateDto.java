package com.wct.animall.dto;

public class CategoryUpdateDto {
	private String nameCategory;
	private int animalId;

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public int getAnimalId() {
		return animalId;
	}

	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}

	public CategoryUpdateDto(String nameCategory, int animalId) {
		super();
		this.nameCategory = nameCategory;
		this.animalId = animalId;
	}

	public CategoryUpdateDto() {
		super();
	}

}
