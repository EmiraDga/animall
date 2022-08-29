package com.wct.animall.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wct.animall.dto.AnimalDto;
import com.wct.animall.dto.AnimalSaveDto;
import com.wct.animall.dto.AnimalUpdateDto;
import com.wct.animall.model.Animal;

@Service
public class AnimalConverter {

	@Autowired
	private ModelMapper modelMapper;

	public AnimalDto convertToDto(Animal animal) {

		AnimalDto Animaldto = modelMapper.map(animal, AnimalDto.class);
		return Animaldto;
	}

	public List<AnimalDto> entityToDto(List<Animal> animal) {
		return animal.stream().map(x -> convertToDto(x)).collect(Collectors.toList());
	}

	public Animal convertToEntity(AnimalDto Animaldto) {
		Animal animal = modelMapper.map(Animaldto, Animal.class);
		return animal;
	}

	// SaveAnimal

	public AnimalSaveDto convertToSaveDto(Animal animal) {

		AnimalSaveDto Animaldto = modelMapper.map(animal, AnimalSaveDto.class);
		return Animaldto;
	}

	public Animal convertToSaveEntity(AnimalSaveDto Animaldto) {
		Animal animal = modelMapper.map(Animaldto, Animal.class);
		return animal;
	}

	// update

	public AnimalDto convertToUpdateDto(Animal animal) {

		AnimalDto Animaldto = modelMapper.map(animal, AnimalDto.class);
		return Animaldto;
	}

	public Animal convertToUpdateEntity(AnimalUpdateDto Animaldto) {
		Animal animal = modelMapper.map(Animaldto, Animal.class);
		return animal;
	}

}
