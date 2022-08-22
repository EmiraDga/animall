package com.wct.animall.dto;

public class UserDto {
	private Long id;
	private String firstname;

	public UserDto(long id, String firstname) {
		super();
		this.id = id;
		this.firstname = firstname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
}
