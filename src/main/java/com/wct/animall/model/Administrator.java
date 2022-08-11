package com.wct.animall.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Entity
@Data
@DiscriminatorValue("Admin")
public class Administrator extends User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_admin;

	public Long getId_admin() {
		return id_admin;
	}

	public void setId_admin(Long id_admin) {
		this.id_admin = id_admin;
	}

	public Administrator() {
	}

	public Administrator(String username, String email, String password) {
		super(username, email, password);
	}

}