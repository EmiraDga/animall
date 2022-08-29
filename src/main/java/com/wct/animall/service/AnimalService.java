package com.wct.animall.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wct.animall.converter.AnimalConverter;
import com.wct.animall.dto.AnimalDto;
import com.wct.animall.dto.AnimalSaveDto;
import com.wct.animall.dto.AnimalUpdateDto;
import com.wct.animall.model.Animal;
import com.wct.animall.model.Category;
import com.wct.animall.repository.AnimalRepository;
import com.wct.animall.repository.CategoryRepository;

@Service
public class AnimalService {

	@Autowired
	AnimalConverter converter;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AnimalRepository animalRepo;

	@Autowired
	private CategoryRepository categRepo;

	// GET ALL
	public List<AnimalDto> findAll() {
		List<AnimalDto> animalsDtoList = new ArrayList<>();
		animalRepo.findAll().forEach(animal -> animalsDtoList.add(converter.convertToDto(animal)));
		return animalsDtoList;
	}

	// Return Single User
	public AnimalDto findById(int id) {
		Animal animal = animalRepo.findById(id).get();
		var dto = converter.convertToDto(animal);
		return dto;
	}

	public void RemoveAnimal(int id) {
		animalRepo.deleteById(id);
	}

	// UN PROBLEME AU NIVEAU ANIMAL ET CATEGORY
	public AnimalSaveDto saveAnimalDto(AnimalSaveDto dto) throws Exception {
		Animal animal = modelMapper.map(dto, Animal.class);
		Category category = categRepo.findById(dto.getCategoryId())
				.orElseThrow(() -> new Exception("animal Not found"));
		animal.setCategory(category);
		return converter.convertToSaveDto(animalRepo.save(animal));

	}

//UN PROBLEME AU NIVEAU ANIMAL ET CATEGORY
	public AnimalDto updateAnimalDto(int id, AnimalUpdateDto dto) {
		Animal SavedAnimal = animalRepo.findById(id).get();
		Animal AnimalToUpdate = converter.convertToUpdateEntity(dto);

		SavedAnimal.setName(AnimalToUpdate.getName());
		SavedAnimal.setAge(AnimalToUpdate.getAge());
		SavedAnimal.setBreed(AnimalToUpdate.getBreed());
		SavedAnimal.setImage(AnimalToUpdate.getImage());
		SavedAnimal.setColor(AnimalToUpdate.getColor());
		SavedAnimal.setGender(AnimalToUpdate.getGender());
		SavedAnimal.setVaccinated(AnimalToUpdate.isVaccinated());
		SavedAnimal.setTrained(AnimalToUpdate.isTrained());
		SavedAnimal.setCategory(AnimalToUpdate.getCategory());

		return converter.convertToUpdateDto(animalRepo.save(SavedAnimal));
	}

}
