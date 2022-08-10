package com.wct.animall.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wct.animall.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
