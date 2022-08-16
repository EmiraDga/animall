package com.wct.animall.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wct.animall.model.Authority;
import com.wct.animall.model.User;

@Service
public class UserService {

	private List<User> users = new ArrayList<>();

	// POST
	public void addUser(User user) {
		users.add(user);
	}

	// GET
	public User getUser(Long id) {
		return users.stream().filter(u -> u.getId().equals(id)).findFirst().get();

	}

	public UserService() {
		users.add(new User("Samosd", "samosd@gmil.com", "1918495", Authority.ROLE_USER, "258889336", "55714825", "gogo",
				"brain", true, true, false, true));
	}

	// Return all users
	public List<User> getAllUsers() {
		return users;
	}

	// Return Single User
	public User getSignleUser(Long id) {
		for (User u : users) {
			if (u.getId() == id)
				return u;
		}
		return null;
	}

	// Save the user with its new changes
	public void saveUser(User user) {
		this.users.add(user);
	}

	// update the user's Username (lastN + FirstN)
	public void updateUser(User user) {

		for (User u : users) {
			if (u.getId() == user.getId()) {
				u.setUsername(user.getUsername());
				u.setFirstname(user.getFirstname());
				u.setLastname(user.getLastname());

			}
		}

	}

	// Remove a user
	public void deleteUser(Long id) {
		users.remove(id);
	}
}
