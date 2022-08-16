package com.wct.animall.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wct.animall.model.Animal;
import com.wct.animall.repository.AnimalRepository;

@Service
public class AnimalService {
	private List<Animal> animals = new ArrayList<>();

	// POST
	public void addAnimal(Animal animal) {
		animals.add(animal);
	}

	// GET
	public Animal getAnimal(Long id) {
		return animals.stream().filter(u -> u.getId().equals(id)).findFirst().get();

	}
	/*
	 * TODO public AnimalService() { animals.add(new
	 * Animal("black","F","src/main/resources/images/images.jpg","BeadBull","Rex",2,
	 * 25.5,23.6,10,true,false,Category)); }
	 */

	// Return all Animals
	public List<Animal> getAllAnimals() {
		return animals;
	}

	// Return Single Animal
	public Animal getSignleAnimal(int id) {
		for (Animal a : animals) {
			if (a.getId() == id)
				return a;
		}
		return null;
	}

	// Save the animal with its new changes
	public void saveAnimal(Animal animal) {
		this.animals.add(animal);
	}

	// update the animals' name (lastN + FirstN)
	public void updateAnimal(Animal animal) {

		for (Animal a : animals) {
			if (a.getId() == animal.getId()) {
				a.setAge(animal.getAge());
				a.setBreed(animal.getBreed());
				a.setColor(animal.getBreed());

			}
		}

	}

	// Remove an animal
	public void deleteAnimal(int id) {
		animals.remove(id);
	}

	/*******
	 * Using JpaRepository methods
	 **************************/

	@Autowired
	private AnimalRepository animalRepository;

	// Return all animals
	public List<Animal> getAllTheAnimals() {
		animalRepository.findAll().forEach(animals::add);
		return animals;
	}

	// Return Single Animal
	public Animal getOnlySingleAnimal(int id) {
		Optional<Animal> optionalAnimal = animalRepository.findById(id);
		if (optionalAnimal.isPresent()) {
			return optionalAnimal.get();
		}
		return null;

	}

	// Save the animal with its new changes
	public void saveTheAnimal(Animal animal) {
		animalRepository.save(animal);
	}

	// update an animal
	public void updateTheAnimal(Animal a) {
		animalRepository.save(a);

	}

	// Remove
	public void RemoveAnimal(int id) {
		animalRepository.deleteById(id);
	}

}
