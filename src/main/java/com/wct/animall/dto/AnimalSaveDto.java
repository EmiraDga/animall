package com.wct.animall.dto;

public class AnimalSaveDto {

	private String name;
	private int age;
	private String color;
	private String gender;
	private String Breed;
	private String image;
	private boolean vaccinated;
	private boolean trained;
	private Long categoryId;

	public AnimalSaveDto() {
	}

	public AnimalSaveDto(String name, int age, String color, String gender, String breed, String image,
			boolean vaccinated, boolean trained, Long categoryId) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.age = age;
		this.color = color;
		this.gender = gender;
		this.Breed = breed;
		this.image = image;
		this.vaccinated = vaccinated;
		this.trained = trained;

	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
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

	public String getBreed() {
		return Breed;
	}

	public void setBreed(String breed) {
		Breed = breed;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

}
