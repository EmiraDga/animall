package com.wct.animall.controller;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wct.animall.model.User;
import com.wct.animall.security.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class UserControllerAPI {
	@Autowired
	private UserService userService;

	ConcurrentMap<Long, User> users = new ConcurrentHashMap<>();

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

	/********************* ????? ****************/
	// POST
	@PostMapping(value = "/users/add")
	public User addUser(@RequestBody User user) {
		users.put(user.getId(), user);
		return user;
	}

	/****************** ????? *********************/

	// POST
	@RequestMapping(value = "/users/save", method = RequestMethod.POST)
	public void add(@RequestBody User user) {
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
}
