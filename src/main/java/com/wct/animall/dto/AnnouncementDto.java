package com.wct.animall.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.wct.animall.model.StateType;

public class AnnouncementDto {

	private Long id;

	private StateType state;

	private String location;

	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private String dateCreated;

	private String description;

	private UserDto userDto;

	public AnnouncementDto() {
	}

	public AnnouncementDto(Long id, StateType state, String location, String dateCreated, String description,
			UserDto userDto) {
		super();
		this.id = id;
		this.state = state;
		this.location = location;
		this.dateCreated = dateCreated;
		this.description = description;
		this.userDto = userDto;
	}

	public UserDto getUser() {
		return userDto;
	}

	public void setUser(UserDto user) {
		this.userDto = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StateType getState() {
		return state;
	}

	public void setState(StateType state) {
		this.state = state;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
