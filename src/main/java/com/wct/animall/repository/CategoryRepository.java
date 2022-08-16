package com.wct.animall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wct.animall.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
