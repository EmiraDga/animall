package com.wct.animall.model;

public enum Authority {

	USER("USER"), ADMIN("ADMIN");

	private String name;

	private Authority(String name) {
		this.name = name;
	}

}
