package com.wct.animall.dto;

public class CategoryDto {

	private Long id;
	private String nameCategory;

	public CategoryDto() {
	}

	public CategoryDto(Long id, String nameCategory) {
		super();
		this.id = id;
		this.nameCategory = nameCategory;
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
