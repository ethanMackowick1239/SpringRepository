package com.tcs.auth.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.auth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByEmail(String email);
	Optional<User> findByFirstName(String firstName);
	Boolean existsByEmail(String email);
	Boolean existsByUsername(String username);

}
