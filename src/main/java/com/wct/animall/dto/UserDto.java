package com.wct.animall.dto;

import java.util.List;

import com.wct.animall.model.Announcement;

public class UserDto {
	private Long id;

	private String email;

	private String lastname;

	private String firstname;

	private String mobile;

	private String phone;

	private String password;

	private String username;

	private List<Announcement> annoucements;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Announcement> getAnnoucements() {
		return annoucements;
	}

	public void setAnnoucements(List<Announcement> annoucements) {
		this.annoucements = annoucements;
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
