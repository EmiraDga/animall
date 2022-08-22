package com.wct.animall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wct.animall.model.User;
import com.wct.animall.repository.UserRepository;
import com.wct.animall.security.service.UserService;

//@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
public class UserControllerAPI {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepo;

	/** b1 */
	// GET
	// get all users
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.getAllTheUsers();
	}

	/** b1 */
	// get a user By ID
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable Long id) {
		return userService.getOnlySingleUser(id);
	}

	/** b1 */

	/********************* ADD : POST ****************/
	// POST
	/*
	 * public UserDto addUser(@RequestBody UserDto user) {
	 * System.out.println("add the user"); userService.saveUser(user); return user;
	 * }
	 */
	/*
	 * @PostMapping(value = "/users/add") public UserDto addUser(@RequestBody
	 * UserDto user) { System.out.println("add the user");
	 * userService.saveUser(user); return user; }
	 */
	@PostMapping(value = "/users/add")
	public User addUser(@RequestBody User user) {
		System.out.println("add the user");
		userService.saveUser(user);
		return user;
	}

	/****************** ADD : POST *********************/

	// DELETE
	@RequestMapping(value = "/users/delete/{id}", method = RequestMethod.DELETE)
	public void deleteUser(Long id) {
		userService.RemoveUser(id);
	}

	// UPDATE | PUT
	@PostMapping("/update/{id}")
	public Long saveUser(@RequestBody User user) {
		userService.saveTheUser(user);
		return user.getId();
	}

}
