package com.vatsalya.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vatsalya.dto.RecordDto;
import com.vatsalya.model.Category;
import com.vatsalya.model.User;
import com.vatsalya.repository.CategoryRepository;
import com.vatsalya.repository.RecordRepository;
import com.vatsalya.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecordService {
	private final RecordRepository recordRepository;
	private final CategoryRepository categoryRepository;
	private final UserRepository userRepository;

	public List<RecordDto> getAllRecords(Long userId, Boolean isActive, String search) {
		List<Record> records;

		if (isActive != null && search != null && !search.isEmpty()) {
			records = recordRepository.findByUserIdAndIsActiveAndNameContainingIgnoreCase(userId, isActive, search);
		} else if (isActive != null) {
			records = recordRepository.findByUserIdAndIsActive(userId, isActive);
		} else if (search != null && !search.isEmpty()) {
			records = recordRepository.findByUserIdAndNameContainingIgnoreCase(userId, search);
		} else {
			records = recordRepository.findByUserId(userId);
		}

		return records.stream().map(this::convertToDto).toList();
	}

	public RecordDto getRecordById(Long id, Long userId) {
		Record record = recordRepository.findById(id).orElseThrow(() -> new RuntimeException("Record not found"));
		return convertToDto(record);
	}

	public RecordDto createRecord(RecordDto recordDto, Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

		Category category = categoryRepository.findById(recordDto.getCategoryId())
				.orElseThrow(() -> new RuntimeException("Category not found"));

		RecordDto record = RecordDto.builder().name(recordDto.getName()).description(recordDto.getDescription())
				.isActive(recordDto.isActive()).categoryId(category).user(user).build();

		RecordDto savedRecord = recordRepository.save(record);
		return convertToDto(savedRecord);
	}

	public RecordDto updateRecord(Long id, RecordDto recordDto, Long userId) {
		RecordDto record = recordRepository.findByIdAndUserId(id, userId)
				.orElseThrow(() -> new RuntimeException("Record not found"));

		Category category = categoryRepository.findById(recordDto.getCategoryId())
				.orElseThrow(() -> new RuntimeException("Category not found"));

		record.setName(recordDto.getName());
		record.setDescription(recordDto.getDescription());
		record.setIsActive(recordDto.isActive());
		record.setCategory(category);

		Record updatedRecord = recordRepository.save(record);
		return convertToDto(updatedRecord);
	}

	public void deleteRecord(Long id, Long userId) {
		Record record = recordRepository.findByIdAndUserId(id, userId)
				.orElseThrow(() -> new RuntimeException("Record not found"));
		recordRepository.delete(record);
	}

	public void deleteMultipleRecords(List<Long> ids, Long userId) {
		recordRepository.deleteAllByIdInAndUserId(ids, userId);
	}

	private RecordDto convertToDto(RecordDto record) {
		return RecordDto.builder().id(record.getId()).name(record.getName()).description(record.getDescription())
				.isActive(record.isActive()).categoryId(record.getCategory().getId())
				.categoryName(record.getCategory().getName()).userId(record.getUser().getId())
				.userName(record.getUser().getName()).build();
	}
}
