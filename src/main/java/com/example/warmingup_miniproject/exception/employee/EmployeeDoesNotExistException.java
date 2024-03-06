package com.example.warmingup_miniproject.exception.employee;

import static com.example.warmingup_miniproject.exception.message.ExceptionMessage.*;

import com.example.warmingup_miniproject.exception.WarmingUpException;

public class EmployeeDoesNotExistException extends WarmingUpException {
	public EmployeeDoesNotExistException() {
		super(ERR_EMPLOYEE_DOES_NOT_EXIST.getMessage(),
				ERR_EMPLOYEE_DOES_NOT_EXIST.getStatus());
	}
}
