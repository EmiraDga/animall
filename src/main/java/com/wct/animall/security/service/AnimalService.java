package com.wct.animall.security.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wct.animall.converter.AnimalConverter;
import com.wct.animall.dto.AnimalDto;
import com.wct.animall.model.Animal;
import com.wct.animall.repository.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	AnimalRepository animalRepository;

	@Autowired
	AnimalConverter converter;

	/*
	 * private List<Animal> animals = new ArrayList<>();
	 * 
	 * // POST public void addAnimal(Animal animal) { animals.add(animal); }
	 * 
	 * // GET public Animal getAnimal(Long id) { return animals.stream().filter(a ->
	 * a.getId().equals(id)).findFirst().get();
	 * 
	 * }
	 */
	/*
	 * TODO public AnimalService() { animals.add(new
	 * Animal("black","F","src/main/resources/images/images.jpg","BeadBull","Rex",2,
	 * 25.5,23.6,10,true,false,Category)); }
	 */

	// Return all Animals
	/*
	 * public List<Animal> getAllAnimals() { return animals; }
	 * 
	 * // Return Single Animal public Animal getSignleAnimal(int id) { for (Animal a
	 * : animals) { if (a.getId() == id) return a; } return null; }
	 * 
	 * // Save the animal with its new changes public void saveAnimal(Animal animal)
	 * { this.animals.add(animal); }
	 * 
	 * // update the animals' name (lastN + FirstN) public void updateAnimal(Animal
	 * animal) {
	 * 
	 * for (Animal a : animals) { if (a.getId() == animal.getId()) {
	 * a.setAge(animal.getAge()); a.setBreed(animal.getBreed());
	 * a.setColor(animal.getBreed());
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * // Remove an animal public void deleteAnimal(int id) { animals.remove(id); }
	 */

	public List<AnimalDto> findAll() {
		var r = animalRepository.findAll();
		return r.stream().map(animal -> converter.convertToDto(animal)).collect(Collectors.toList());
	}

	// Return Single User
	public Animal findById(int id) {
		return animalRepository.findById(id).get();
	}

	// Remove
	public void RemoveAnimal(int id) {
		animalRepository.deleteById(id);
	}

	public AnimalDto saveAnimalDto(AnimalDto dto) {
		Animal animal = converter.convertToEntity(dto);
		return converter.convertToDto(animalRepository.save(animal));
	}

	public AnimalDto updateAnimalDto(int id, AnimalDto dto) {
		Animal SavedAnimal = animalRepository.findById(id).get();
		Animal animalToUpdate = converter.convertToEntity(dto);

		SavedAnimal.setAge(animalToUpdate.getAge());
		SavedAnimal.setName(animalToUpdate.getName());
		SavedAnimal.setColor(animalToUpdate.getColor());
		SavedAnimal.setBreed(animalToUpdate.getBreed());
		SavedAnimal.setImage(animalToUpdate.getImage());
		SavedAnimal.setGender(animalToUpdate.getGender());
		SavedAnimal.setVaccinated(animalToUpdate.isVaccinated());
		SavedAnimal.setTrained(animalToUpdate.isTrained());

		return converter.convertToDto(animalRepository.save(SavedAnimal));
	}

	// Return all animals
	/*
	 * public List<Animal> getAllTheAnimals() {
	 * animalRepository.findAll().forEach(animals::add); return animals; }
	 * 
	 * // Return Single Animal public Animal getOnlySingleAnimal(int id) {
	 * Optional<Animal> optionalAnimal = animalRepository.findById(id); if
	 * (optionalAnimal.isPresent()) { return optionalAnimal.get(); } return null;
	 * 
	 * }
	 * 
	 * // Save the animal with its new changes public void saveTheAnimal(Animal
	 * animal) { animalRepository.save(animal); }
	 * 
	 * // update an animal public void updateTheAnimal(Animal a) {
	 * animalRepository.save(a);
	 * 
	 * }
	 * 
	 * // Remove public void RemoveAnimal(int id) { animalRepository.deleteById(id);
	 * }
	 */

}
