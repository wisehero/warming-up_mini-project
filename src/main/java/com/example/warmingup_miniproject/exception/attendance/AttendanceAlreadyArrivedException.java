package com.example.warmingup_miniproject.exception.attendance;

import static com.example.warmingup_miniproject.exception.message.ExceptionMessage.*;

import com.example.warmingup_miniproject.exception.WarmingUpException;

public class AttendanceAlreadyArrivedException extends WarmingUpException {

	public AttendanceAlreadyArrivedException() {
		super(ERR_ATTENDANCE_RECORD_EXISTS.getMessage(), ERR_ATTENDANCE_RECORD_EXISTS.getStatus());
	}
}
