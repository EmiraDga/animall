package com.wct.animall.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.wct.animall.model.Authority;
import com.wct.animall.model.Role;

@Repository
@NoRepositoryBean
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(Authority name);
}
