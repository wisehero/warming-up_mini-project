package com.example.warmingup_miniproject.exception.handler;

import java.util.HashMap;
import java.util.Map;

import lombok.Builder;

@Builder
public record ResponseValidationException(
		int status,
		String message,
		Map<String, String> validation
) {
	public ResponseValidationException {

		validation = validation != null ? validation : new HashMap<>();
	}
}
