package com.wct.animall.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	String name;

	@OneToMany(mappedBy = "category")
	private List<Animal> animals;

	public Category() {
	}

	public Category(@NotBlank @Size(max = 20) String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Animal> getAnimal() {
		return animals;
	}

	public void setAnimal(List<Animal> animals) {
		this.animals = animals;
	}

}
