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
import com.wct.animall.dto.UserSaveDto;
import com.wct.animall.dto.UserUpdateDto;
import com.wct.animall.model.User;
import com.wct.animall.security.service.UserService;

//@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
public class UserControllerAPI {
	@Autowired
	private UserService userService;

	@Autowired
	UserConverter converter;

	@GetMapping("/users")
	public List<UserDto> GetAll() {
		return userService.findAll();
	}

	@GetMapping("/users/{id}")
	public UserDto findByID(@PathVariable Long id) {
		User usr = userService.findById(id);
		return converter.convertToDto(usr);
	}

	@PostMapping("/users/add")
	public UserSaveDto saveUserDto(UserSaveDto dto) {
		return userService.saveUserDto(dto);
	}

	@RequestMapping(value = "/users/delete/{id}", method = RequestMethod.DELETE)
	public void deleteUser(Long id) {
		userService.RemoveUser(id);
	}

	@PutMapping("/users/update/{id}")
	public UserUpdateDto updateUser(@PathVariable("id") Long id,
			@org.springframework.web.bind.annotation.RequestBody UserUpdateDto dto) {
		return userService.updateUserDto(id, dto);
	}

}
