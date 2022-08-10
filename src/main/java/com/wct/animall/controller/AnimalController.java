package com.wct.animall.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class AnimalController {
	/*
	 * @Autowired private EmployeeRepository employeeRepository;
	 * 
	 * // get all employees
	 * 
	 * @GetMapping("/employees") public List<Employee> getAllEmployees() { return
	 * employeeRepository.findAll(); }
	 */
}
