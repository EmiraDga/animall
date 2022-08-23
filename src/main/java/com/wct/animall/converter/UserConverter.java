package com.wct.animall.converter;

import com.wct.animall.dto.UserDto;
import com.wct.animall.model.User;

public class UserConverter {

	public UserDto entityToDto(User user) {

		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setEmail(user.getEmail());
		dto.setFirstname(user.getFirstname());
		dto.setLastname(user.getLastname());
		dto.setPassword(user.getPassword());
		dto.setPhone(user.getPhone());
		dto.setUsername(user.getUsername());

		return dto;
	}

	public User DtoToEntity(UserDto dto) {

		User usr = new User();

		usr.setId(dto.getId());
		usr.setEmail(dto.getEmail());
		usr.setFirstname(dto.getFirstname());
		usr.setLastname(dto.getLastname());
		usr.setPassword(dto.getPassword());
		usr.setPhone(dto.getPhone());
		usr.setUsername(dto.getUsername());

		return usr;
	}

}
