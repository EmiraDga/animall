package com.wct.animall.dto;

import java.util.Date;

public class AnnouncementDto {

	private Long id;

	private String state;

	String location;

	Date createdDate;

	String description;

	private UserDto userDto;

	public AnnouncementDto() {
	}

	public AnnouncementDto(Long id, String state, String location, Date createdDate, String description,
			UserDto userDto) {
		super();
		this.id = id;
		this.state = state;
		this.location = location;
		this.createdDate = createdDate;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
