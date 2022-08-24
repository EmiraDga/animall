package com.wct.animall.dto;

public class AnnouncemetDto {

	private Long id;

	private String state;

	public AnnouncemetDto() {
	}

	public AnnouncemetDto(Long id, String state) {
		super();
		this.id = id;
		this.state = state;
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
