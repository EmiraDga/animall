package com.wct.animall.dto;

import java.util.Date;

public class AnnouncementUpdateDto {

	private String state;

	private Long userId;

	String location;

	Date createdDate;

	String description;

	public AnnouncementUpdateDto() {
		super();
	}

	public AnnouncementUpdateDto(String state, Long userId, String location, Date createdDate, String description) {
		super();
		this.state = state;
		this.userId = userId;
		this.location = location;
		this.createdDate = createdDate;
		this.description = description;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
