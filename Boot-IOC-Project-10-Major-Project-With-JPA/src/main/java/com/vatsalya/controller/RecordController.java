package com.vatsalya.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vatsalya.dto.RecordDto;
import com.vatsalya.service.RecordService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
public class RecordController {
	private final RecordService recordService;

	@GetMapping
	public ResponseEntity<List<RecordDto>> getAllRecords(@RequestParam(required = false) Boolean isActive,
			@RequestParam(required = false) String search, @AuthenticationPrincipal UserDetails userDetails) {
		Long userId = getUserIdFromPrincipal(userDetails);
		return ResponseEntity.ok(recordService.getAllRecords(userId, isActive, search));
	}

	@GetMapping("/{id}")
	public ResponseEntity<RecordDto> getRecordById(@PathVariable Long id,
			@AuthenticationPrincipal UserDetails userDetails) {
		Long userId = getUserIdFromPrincipal(userDetails);
		return ResponseEntity.ok(recordService.getRecordById(id, userId));
	}

	@PostMapping
	public ResponseEntity<RecordDto> createRecord(@RequestBody RecordDto recordDto,
			@AuthenticationPrincipal UserDetails userDetails) {
		Long userId = getUserIdFromPrincipal(userDetails);
		return ResponseEntity.ok(recordService.createRecord(recordDto, userId));
	}

	@PutMapping("/{id}")
	public ResponseEntity<RecordDto> updateRecord(@PathVariable Long id, @RequestBody RecordDto recordDto,
			@AuthenticationPrincipal UserDetails userDetails) {
		Long userId = getUserIdFromPrincipal(userDetails);
		return ResponseEntity.ok(recordService.updateRecord(id, recordDto, userId));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRecord(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		Long userId = getUserIdFromPrincipal(userDetails);
		recordService.deleteRecord(id, userId);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteMultipleRecords(@RequestBody List<Long> ids,
			@AuthenticationPrincipal UserDetails userDetails) {
		Long userId = getUserIdFromPrincipal(userDetails);
		recordService.deleteMultipleRecords(ids, userId);
		return ResponseEntity.noContent().build();
	}

	private Long getUserIdFromPrincipal(UserDetails userDetails) {
		String email = userDetails.getUsername();
		return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found")).getId();
	}
}
