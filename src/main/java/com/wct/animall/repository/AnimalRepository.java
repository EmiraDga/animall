package com.wct.animall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wct.animall.model.Animal;
import com.wct.animall.model.Category;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

	Category save(Category category);

	List<Animal> findAllById(int i);

	List<Animal> findByCategoryId(Long categoryId);

}
