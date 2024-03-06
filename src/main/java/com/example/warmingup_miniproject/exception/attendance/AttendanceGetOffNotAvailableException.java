package com.example.warmingup_miniproject.exception.attendance;

import static com.example.warmingup_miniproject.exception.message.ExceptionMessage.*;

import com.example.warmingup_miniproject.exception.WarmingUpException;

public class AttendanceGetOffNotAvailableException extends WarmingUpException {
	public AttendanceGetOffNotAvailableException() {
		super(ERR_GET_OFF_NOT_AVAILABLE.getMessage(),
				ERR_GET_OFF_NOT_AVAILABLE.getStatus());
	}
}
