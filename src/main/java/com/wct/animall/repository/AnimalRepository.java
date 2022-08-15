package com.wct.animall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wct.animall.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

	@Override
	List<Animal> findAll();

}
