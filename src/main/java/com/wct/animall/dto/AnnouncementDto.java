package com.wct.animall.dto;

public class AnnouncementDto {

	private Long id;

	private String state;

	private UserDto userDto;

	public AnnouncementDto() {
	}

	public AnnouncementDto(Long id, String state, UserDto userDto) {
		super();
		this.id = id;
		this.state = state;
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

}
