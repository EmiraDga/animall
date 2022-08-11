package com.wct.animall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wct.animall.model.User;
import com.wct.animall.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	// get all users

	@GetMapping("/user")
	public List<User> getAllAnimals() {
		return userRepository.findAll();
	}
}
