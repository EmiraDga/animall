package com.wct.animall.dto;

public class CategorySaveDto {

	private String nameCategory;

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public CategorySaveDto() {
		super();
	}

	public CategorySaveDto(String nameCategory) {
		super();
		this.nameCategory = nameCategory;
	}

}
