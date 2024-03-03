package com.example.warmingup_miniproject.exception.attendance;

import com.example.warmingup_miniproject.exception.WarmingUpException;
import com.example.warmingup_miniproject.exception.message.ExceptionMessage;

public class AttendanceAlreadyArrivedException extends WarmingUpException {
	public AttendanceAlreadyArrivedException() {
		super(ExceptionMessage.ERR_ATTENDANCE_RECORD_EXISTS.name());
	}
}
