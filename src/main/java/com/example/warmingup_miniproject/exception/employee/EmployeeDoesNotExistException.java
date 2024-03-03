package com.example.warmingup_miniproject.exception.employee;

import com.example.warmingup_miniproject.exception.WarmingUpException;
import com.example.warmingup_miniproject.exception.message.ExceptionMessage;

public class EmployeeDoesNotExistException extends WarmingUpException {
	public EmployeeDoesNotExistException() {
		super(ExceptionMessage.ERR_EMPLOYEE_DOES_NOT_EXIST.name());
	}
}