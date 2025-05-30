package com.vatsalya.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vatsalya.dto.CategoryDto;
import com.vatsalya.model.Category;
import com.vatsalya.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
	private final CategoryRepository categoryRepository;

	public List<CategoryDto> getAllCategories() {
		return categoryRepository.findAllByOrderByNameAsc().stream().map(this::convertToDto)
				.collect(Collectors.toList());
	}

	private CategoryDto convertToDto(Category category) {
		return CategoryDto.builder().id(category.getId()).name(category.getName()).build();
	}
}
