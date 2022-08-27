package com.wct.animall.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.wct.animall.model.StateType;

public class AnnouncementUpdateDto {

	private StateType state;

	private Long userId;

	private String location;

	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private String dateCreated;

	private String description;

	public AnnouncementUpdateDto() {
		super();
	}

	public AnnouncementUpdateDto(StateType state, Long userId, String location, String dateCreated,
			String description) {
		super();
		this.state = state;
		this.userId = userId;
		this.location = location;
		this.dateCreated = dateCreated;
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StateType getState() {
		return state;
	}

	public void setState(StateType state) {
		this.state = state;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
