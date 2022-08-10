package com.wct.animall.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Animal")
@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String couleur, sexe, image;

	private int age;

	private float longeur, largeur, poids;

	private boolean vaccination, dressé;

	public Animal() {
	}

}
