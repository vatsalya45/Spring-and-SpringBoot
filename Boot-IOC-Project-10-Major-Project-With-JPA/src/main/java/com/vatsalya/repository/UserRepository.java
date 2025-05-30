package com.vatsalya.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vatsalya.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);

	boolean existsByEmail(String email);

	Optional<User> findByIdAndEmail(Long id, String email);
}