package com.wct.animall.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "announcement")
public class Announcement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	StateType state;

	int nb_announncment;

	String location;

	Date createdDate;

	String description;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "User_id", referencedColumnName = "id")
	private User user;

	public Announcement() {
	}

	public Announcement(Long id, StateType state, int nb_announncment, String location, Date createdDate,
			String description, User user) {
		super();
		this.id = id;
		this.state = state;
		this.nb_announncment = nb_announncment;
		this.location = location;
		this.createdDate = createdDate;
		this.description = description;
		this.user = user;
	}

	public StateType getState() {
		return state;
	}

	public void setState(StateType state) {
		this.state = state;
	}

	public int getNb_announncment() {
		return nb_announncment;
	}

	public void setNb_announncment(int nb_announncment) {
		this.nb_announncment = nb_announncment;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
