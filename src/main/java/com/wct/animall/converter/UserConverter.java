package com.wct.animall.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wct.animall.dto.UserDto;
import com.wct.animall.model.User;

@Service
public class UserConverter {

	@Autowired
	private ModelMapper modelMapper;

	public UserDto convertToDto(User user) {

		UserDto dto = modelMapper.map(user, UserDto.class);

		/*
		 * dto.setId(user.getId()); dto.setEmail(user.getEmail());
		 * dto.setFirstname(user.getFirstname()); dto.setLastname(user.getLastname());
		 * dto.setPassword(user.getPassword()); dto.setPhone(user.getPhone());
		 * dto.setUsername(user.getUsername());
		 */

		return dto;
	}

	public List<UserDto> entityToDto(List<User> user) {
		return user.stream().map(x -> convertToDto(x)).collect(Collectors.toList());
	}

	public User convertToEntity(UserDto dto, User user) {

		modelMapper.map(dto, user);
		return user;
	}

}
