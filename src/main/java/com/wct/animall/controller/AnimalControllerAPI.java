package com.wct.animall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wct.animall.model.Animal;
import com.wct.animall.security.service.AnimalService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class AnimalControllerAPI {

	@Autowired
	private AnimalService animalService;

	/***** GET *****/
	// get all animals
	@RequestMapping(value = "/animals", method = RequestMethod.GET)
	public List<Animal> getAnimals() {
		return animalService.getAllAnimals();
	}

	// get an animal by id
	@RequestMapping(value = "/animals/{id}", method = RequestMethod.POST)
	public Animal getSingleAnimal(@PathVariable int id) {
		return animalService.getOnlySingleAnimal(id);
	}

	/**** POST ****/
// save
	@RequestMapping(value = "/animals/save", method = RequestMethod.POST)
	public void saveAnimal(Animal animal) {
		animalService.saveAnimal(animal);
	}

	/**** PUT ****/
	@RequestMapping(value = "/animals/update", method = RequestMethod.PUT)
	public void updateAnimal(@RequestBody Animal animal) {
		animalService.updateAnimal(animal);
	}

	/**** DELETE ****/
	@RequestMapping(value = "/animals/delete", method = RequestMethod.DELETE)
	public void deleteAnimal(int id) {
		animalService.deleteAnimal(id);
	}

}
