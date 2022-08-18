package com.wct.animall.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wct.animall.model.User;
import com.wct.animall.repository.UserRepository;

@Service
public class UserService {

	private List<User> users = new ArrayList<>();

	/*
	 * // POST public void addUser(User user) { users.add(user); }
	 */

	// GET
	public User getUser(Long id) {
		return users.stream().filter(u -> u.getId().equals(id)).findFirst().get();

	}

	/********* ????? *****/
	/// POST
	/*
	 * public void AddUser() { users.add(new User("Samosd", "samosd@gmil.com",
	 * "1918495", "258889336", "55714825", "gogo", "brain", true, true, false,
	 * true)); }
	 */

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

	/*******
	 * Using JpaRepository methods
	 **************************/

	@Autowired
	private UserRepository userRepo;

// Return all users
	public List<User> getAllTheUsers() {
		userRepo.findAll().forEach(users::add);
		return users;
	}

// Return Single User
	public User getOnlySingleUser(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;

	}

// Save the user with its new changes
	public void saveTheUser(User user) {
		userRepo.save(user);
	}

	// ???? error
// update the user's Username (lastN + FirstN)
	public void updateTheUser(User u) {
		/*
		 * User user1 = userRepo.findById(u.getId()); // crush the variables of the
		 * object found user1.setFirstname("john"); user1.setLastname("dew");
		 * user1.setAge(16); user1.save(userFromDb);
		 */
		userRepo.save(u);

	}

//Remove
	public void RemoveUser(Long id) {
		userRepo.deleteById(id);
	}

}
