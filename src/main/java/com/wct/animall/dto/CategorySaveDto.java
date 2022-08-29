package com.wct.animall.dto;

public class CategorySaveDto {

	private String nameCategory;

	private int AnimalId;

	public String getNameCategory() {
		return nameCategory;
	}

	public CategorySaveDto(String nameCategory, int AnimalId) {
		super();
		this.nameCategory = nameCategory;
		this.AnimalId = AnimalId;
	}

	public CategorySaveDto() {
		super();
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public int getAnimalId() {
		return AnimalId;
	}

	public void setAnimalId(int animalId) {
		AnimalId = animalId;
	}

}
