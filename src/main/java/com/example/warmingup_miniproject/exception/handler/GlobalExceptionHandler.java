package com.example.warmingup_miniproject.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.warmingup_miniproject.exception.WarmingUpException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseValidationException handleValidationExceptions(MethodArgumentNotValidException e) {

		Map<String, String> validationMap = new HashMap<>();
		for (FieldError fieldError : e.getFieldErrors()) {
			validationMap.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		return ResponseValidationException.builder()
				.status(e.getStatusCode().value())
				.message("입력값이 유효하지 않습니다.")
				.validation(validationMap)
				.build();
	}

	@ExceptionHandler(WarmingUpException.class)
	public ResponseWarmingUpException handleResponseWarmingUpException(WarmingUpException e) {
		return ResponseWarmingUpException
				.builder()
				.status(e.getStatus())
				.message(e.getMessage())
				.build();
	}
}
