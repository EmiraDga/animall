package com.wct.animall.controller;

public class UserDto {
	private long id;
	private String firstname;

	public UserDto(long id, String firstname) {
		super();
		this.id = id;
		this.firstname = firstname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
}
