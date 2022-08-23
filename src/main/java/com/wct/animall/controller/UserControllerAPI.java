package com.wct.animall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wct.animall.converter.UserConverter;
import com.wct.animall.dto.UserDto;
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
	UserConverter converter;

	@Autowired
	private UserRepository userRepo;

	@GetMapping("/users")
	public List<UserDto> findAll() {
		List<User> findAll = userService.getAllTheUsers();
		return converter.entityToDto(findAll);
	}

	@GetMapping("/users/{id}")
	public UserDto findByID(@PathVariable Long id) {
		User usr = userService.findById(id);
		return converter.convertToDto(usr);
	}

	@PostMapping("/users/add")
	public UserDto saveUserDto(UserDto dto) {
//		User user = converter.convertToEntity(dto);
//		user = userService.saveUser(user);
//		return converter.convertToDto(user);
		return null;
	}

	@RequestMapping(value = "/users/delete/{id}", method = RequestMethod.DELETE)
	public void deleteUser(Long id) {
		userService.RemoveUser(id);
	}

	@PutMapping("/users/update/{id}")
	public UserDto updateUserDto(@PathVariable("id") Long id,
			@org.springframework.web.bind.annotation.RequestBody UserDto dto) {
		User Saveduser = userService.findById(id);
		User userToUpdate = converter.convertToEntity(dto, Saveduser);

		return converter.convertToDto(userService.saveUser(userToUpdate));
	}

//	@RequestMapping(value = "/users/update/{id}", method = RequestMethod.PUT)
//	public void updateUser(Long id, User user) {
//
//		User userFromDb = userService.getOnlySingleUser(id);
//		userFromDb.setUsername(user.getUsername());
//		userFromDb.setPhone(user.getPhone());
//		userFromDb.setEmail(user.getEmail());
//		userFromDb.setMobile(user.getMobile());
//		userFromDb.setFirstname(user.getFirstname());
//		userFromDb.setLastname(user.getLastname());
//		userFromDb.setPassword(user.getPassword());
//		userFromDb.setAccountNonExpired(user.isAccountNonExpired());
//		userFromDb.setAccountNonLocked(user.isAccountNonLocked());
//		userFromDb.setActive(user.isActive());
//		userFromDb.setAuthority(user.getAuthority());
//		userFromDb.setEnabled(user.isEnabled());
//
//		userService.saveUser(userFromDb);
//	}

	/*
	 * @RequestMapping(value = "/users", method = RequestMethod.GET) public
	 * List<User> getUsers() { return userService.getAllTheUsers(); }
	 * 
	 * @RequestMapping(value = "/users/{id}", method = RequestMethod.GET) public
	 * User getUserById(@PathVariable Long id) { return
	 * userService.getOnlySingleUser(id); }
	 */
	// POST
	/*
	 * public UserDto addUser(@RequestBody UserDto user) {
	 * System.out.println("add the user"); userService.saveUser(user); return user;
	 * }
	 * 
	 * 
	 * @PostMapping(value = "/users/add") public UserDto addUser(@RequestBody
	 * UserDto user) { System.out.println("add the user");
	 * userService.saveUser(user); return user; }
	 */
	/*
	 * @PostMapping(value = "/users/add") public User addUser(@RequestBody User
	 * user) { System.out.println("add the user"); userService.saveUser(user);
	 * return user; }
	 */
	/*
	 * @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.DELETE)
	 * public void deleteUser(Long id) { userService.RemoveUser(id); }
	 * 
	 * @PostMapping("/update/{id}") public Long saveUser(@RequestBody User user) {
	 * userService.saveTheUser(user); return user.getId(); }
	 */

}
