package com.vatsalya.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	private int status;
	private String message;
	private LocalDateTime timestamp;

	// Factory method for convenience
	public static ErrorResponse of(HttpStatus status, String message) {
		return new ErrorResponse(status.value(), message, LocalDateTime.now());
	}
}