package com.wct.animall.dto;

import java.util.List;

import com.wct.animall.model.Animal;

public class CategoryAnimalDto {
	private Long id;
	private String nameCategory;
	private List<Animal> animals;

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

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public CategoryAnimalDto(Long id, String nameCategory, List<Animal> animals) {
		super();
		this.id = id;
		this.nameCategory = nameCategory;
		this.animals = animals;
	}

	public CategoryAnimalDto() {
		super();
	}

}
