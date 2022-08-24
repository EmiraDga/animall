package com.wct.animall.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "Animal")
@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "announcement_id")
	private Announcement announce;

	private String color, gender, Breed, name;
	private String image;
	private int age;

	private float weight, length, width;

	private boolean vaccinated, trained;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Category_id", referencedColumnName = "id")
	private Category category;

	// Optional<Category> categories = CategoryRepository.findB;

	public Animal() {

	}

	public Animal(String color, String gender, String image, String breed, String name, int age, float weight,
			float length, float width, boolean vaccinated, boolean trained, Category category) {
		this.color = color;
		this.gender = gender;
		this.image = image;
		this.Breed = breed;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.length = length;
		this.width = width;
		this.vaccinated = vaccinated;
		this.trained = trained;
		this.category = category;

	}

	public Animal(String color, String gender, String image, String breed, String name, int age, float weight,
			float length, float width, boolean vaccinated, boolean trained) {
		this.color = color;
		this.gender = gender;
		this.image = image;
		this.Breed = breed;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.length = length;
		this.width = width;
		this.vaccinated = vaccinated;
		this.trained = trained;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBreed() {
		return Breed;
	}

	public void setBreed(String breed) {
		Breed = breed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public boolean isVaccinated() {
		return vaccinated;
	}

	public void setVaccinated(boolean vaccinated) {
		this.vaccinated = vaccinated;
	}

	public boolean isTrained() {
		return trained;
	}

	public void setTrained(boolean trained) {
		this.trained = trained;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Announcement getAnnounce() {
		return announce;
	}

	public void setAnnounce(Announcement announce) {
		this.announce = announce;
	}

}
