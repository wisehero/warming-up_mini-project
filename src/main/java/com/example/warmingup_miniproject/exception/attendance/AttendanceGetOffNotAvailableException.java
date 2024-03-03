package com.example.warmingup_miniproject.exception.attendance;

import com.example.warmingup_miniproject.exception.WarmingUpException;
import com.example.warmingup_miniproject.exception.message.ExceptionMessage;

public class AttendanceGetOffNotAvailableException extends WarmingUpException {
	public AttendanceGetOffNotAvailableException() {
		super(ExceptionMessage.ERR_GET_OFF_NOT_AVAILABLE.name());
	}
}