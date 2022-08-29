package com.wct.animall.controller;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wct.animall.converter.AnimalConverter;
import com.wct.animall.dto.AnimalDto;
import com.wct.animall.dto.AnimalSaveDto;
import com.wct.animall.dto.AnimalUpdateDto;
import com.wct.animall.model.Animal;
import com.wct.animall.service.AnimalService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class AnimalControllerAPI {

	@Autowired
	AnimalConverter converter;

	@Autowired
	private AnimalService animalService;

	ConcurrentMap<Integer, Animal> animals = new ConcurrentHashMap<>();

	/********************* ADD AN ANIMAL ****************/
//	// POST
//	/@PostMapping(value = "/animals/add")
//	public Animal addAnimal(@RequestBody Animal animal) {
//		animals.put(animal.getId(), animal);
//		return animal;
//	}

	/****************** ADD AN ANIMAL ********/

	/***** GET *****/
	// get all animals

	@RequestMapping(value = "/animals", method = RequestMethod.GET)
	public List<AnimalDto> GetAll() {
		return animalService.findAll();
	}

	@GetMapping("/animals/{id}")
	public AnimalDto findByID(@PathVariable int id) {
		return animalService.findById(id);
	}

	@PostMapping("/animals/add")
	public AnimalSaveDto saveUserDto(AnimalSaveDto dto) throws Exception {
		return animalService.saveAnimalDto(dto);
	}

	@RequestMapping(value = "/animals/delete/{id}", method = RequestMethod.DELETE)
	public void deleteAnimal(int id) {
		animalService.RemoveAnimal(id);
	}

	@PutMapping("/animals/update/{id}")
	public AnimalDto updateAnimal(@PathVariable("id") int id,
			@org.springframework.web.bind.annotation.RequestBody AnimalUpdateDto dto) {
		return animalService.updateAnimalDto(id, dto);
	}

//	// get an animal by id
//	@RequestMapping(value = "/animals/{id}", method = RequestMethod.GET)
//	public Animal getSingleAnimal(@PathVariable int id) {
//		return animalService.getOnlySingleAnimal(id);
//	}
//
//	/**** POST ****/
//// save
//	@RequestMapping(value = "/animals/save", method = RequestMethod.POST)
//	public void saveAnimal(Animal animal) {
//		animalService.saveAnimal(animal);
//	}
//
//	/**** PUT ****/
//	@RequestMapping(value = "/animals/update", method = RequestMethod.PUT)
//	public void updateAnimal(@RequestBody Animal animal) {
//		animalService.updateAnimal(animal);
//	}
//
//	/**** DELETE ****/
//	@RequestMapping(value = "/animals/delete", method = RequestMethod.DELETE)
//	public void deleteAnimal(int id) {
//		animalService.deleteAnimal(id);
//	}

}
