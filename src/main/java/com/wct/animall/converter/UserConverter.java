package com.wct.animall.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.wct.animall.dto.UserDto;
import com.wct.animall.model.User;

@Component
public class UserConverter {

	private ModelMapper modelMapper;

	public UserDto convertToDto(User user) {
		UserDto dto = modelMapper.map(user, UserDto.class);
		return dto;
	}

	public User convertToEntity(UserDto dto) {
		User user = modelMapper.map(dto, User.class);
		return user;
	}

	public List<UserDto> entityToDto(List<User> user) {
		return user.stream().map(x -> convertToDto(x)).collect(Collectors.toList());
	}

}
