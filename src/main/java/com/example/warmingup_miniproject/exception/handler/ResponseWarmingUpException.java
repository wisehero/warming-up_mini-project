package com.example.warmingup_miniproject.exception.handler;

import lombok.Builder;

@Builder
public record ResponseWarmingUpException(
		int status,
		String message
) {
}
