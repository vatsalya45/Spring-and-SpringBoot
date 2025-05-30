package com.vatsalya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vatsalya.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	List<Category> findAllByOrderByNameAsc();
}
