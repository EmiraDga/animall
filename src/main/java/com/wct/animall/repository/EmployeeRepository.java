package com.wct.animall.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wct.animall.model.Employee;

@EntityScan(basePackages = { "com.project.ppaa.model" }) // scan JPA entities
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
