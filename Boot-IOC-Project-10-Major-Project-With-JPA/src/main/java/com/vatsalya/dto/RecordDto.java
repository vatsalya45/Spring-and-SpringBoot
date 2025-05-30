package com.vatsalya.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecordDto {
	private Long id;
	private String name;
	private String description;
	private boolean isActive;
	private Long categoryId;
	private String categoryName;
	private Long userId;
	private String userName;
}
