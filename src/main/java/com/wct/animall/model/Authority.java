package com.wct.animall.model;

public enum Authority {
<<<<<<< HEAD
	ADMIN, USER
=======
	USER("USER"), ADMIN("ADMIN");

	private String name;

	private Authority(String name) {
		this.name = name;
	}

>>>>>>> 9827279 (create the authority class of User roles)
}
