package com.wct.animall.dto;

import java.util.ArrayList;
import java.util.List;

public class CategorySaveDto {

	private String nameCategory;
	private int animalId;

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory, int animalId) {
		this.nameCategory = nameCategory;
		this.animalId = animalId;
	}

	public CategorySaveDto() {
		super();
	}

	public CategorySaveDto(String nameCategory) {
		super();
		this.nameCategory = nameCategory;
	}

	public Iterable<Integer> getAnimalId() {
		List<Integer> aniamls = new ArrayList<>();

		return aniamls;
	}

	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

}
