package com.wct.animall.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wct.animall.dto.AnimalDto;
import com.wct.animall.model.Animal;

@Service
public class AnimalConverter {

	@Autowired
	private ModelMapper modelMapper;

	public AnimalDto convertToDto(Animal animal) {

		AnimalDto Animaldto = modelMapper.map(animal, AnimalDto.class);
		return Animaldto;
	}

}
