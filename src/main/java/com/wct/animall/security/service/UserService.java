package com.wct.animall.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wct.animall.converter.UserConverter;
import com.wct.animall.dto.UserDto;
import com.wct.animall.model.User;
import com.wct.animall.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserConverter converter;

	@Autowired
	private UserRepository userRepo;

	public List<UserDto> findAll() {
		List<UserDto> userDtoList = new ArrayList<>();
		userRepo.findAll().forEach(user -> userDtoList.add(converter.convertToDto(user)));
		return userDtoList;
	}

	// Return Single User
	public User findById(Long id) {
		return userRepo.findById(id).get();
	}

	public User saveUser(User user) {
		System.out.println(user);
		return userRepo.save(user);
	}

// Save the user with its new changes
	public void saveTheUser(User user) {
		userRepo.save(user);
	}

//Remove
	public void RemoveUser(Long id) {
		userRepo.deleteById(id);
	}

	public UserDto saveUserDto(UserDto dto) {
		User user = converter.convertToEntity(dto);
		return converter.convertToDto(userRepo.save(user));
	}

	public UserDto updateUserDto(Long id, UserDto dto) {
		User Saveduser = userRepo.findById(id).get();
		User userToUpdate = converter.convertToEntity(dto);

		Saveduser.setUsername(userToUpdate.getUsername());
		Saveduser.setFirstname(userToUpdate.getFirstname());
		Saveduser.setLastname(userToUpdate.getLastname());
		Saveduser.setEmail(userToUpdate.getEmail());
		Saveduser.setPassword(userToUpdate.getPassword());
		Saveduser.setPhone(userToUpdate.getPhone());

		return converter.convertToDto(userRepo.save(Saveduser));
	}

}
