package com.example.warmingup_miniproject.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public abstract class WarmingUpException extends RuntimeException {

	private final String message;
	private final int status;

	public WarmingUpException(String message, HttpStatus status) {
		this.message = message;
		this.status = status.value();
	}
}
