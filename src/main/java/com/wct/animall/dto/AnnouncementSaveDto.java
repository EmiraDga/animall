package com.wct.animall.dto;

public class AnnouncementSaveDto {

	private String state;

	private Long userId;

	public AnnouncementSaveDto() {
		super();
	}

	public AnnouncementSaveDto(Long id, String state, Long userId) {
		super();
		this.state = state;
		this.userId = userId;
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
