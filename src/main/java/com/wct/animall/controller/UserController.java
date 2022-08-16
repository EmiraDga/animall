package com.wct.animall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wct.animall.model.User;
import com.wct.animall.repository.UserRepository;
import com.wct.animall.security.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	// GET
	// get all users
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.getAllUsers();
	}

	// get a user By ID
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable Long id) {
		return userService.getSignleUser(id);
	}

	// POST
	@RequestMapping(value = "/users/save", method = RequestMethod.POST)
	public void saveUser(@RequestBody User user) {
		userService.saveUser(user);
	}

	// PUT
	@RequestMapping(value = "/users/update", method = RequestMethod.PUT)
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}

	// DELETE
	@RequestMapping(value = "/users/delete", method = RequestMethod.DELETE)
	public void deleteUser(Long id) {
		userService.deleteUser(id);
	}

	/*
	 * // GET
	 * 
	 * @RequestMapping("/user/{id}") public User getUser(@PathVariable Long id) {
	 * return userService.getUser(id); }
	 *
	 *
	 * @RequestMapping(method = RequestMethod.POST, value = "/user") public void
	 * addUser(@RequestBody User user) { userService.addUser(user); }
	 */
}
