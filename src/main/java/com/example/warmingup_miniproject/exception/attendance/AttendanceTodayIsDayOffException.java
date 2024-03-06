package com.example.warmingup_miniproject.exception.attendance;

import static com.example.warmingup_miniproject.exception.message.ExceptionMessage.*;

import org.springframework.http.HttpStatus;

import com.example.warmingup_miniproject.exception.WarmingUpException;
import com.example.warmingup_miniproject.exception.message.ExceptionMessage;

public class AttendanceTodayIsDayOffException extends WarmingUpException {

	public AttendanceTodayIsDayOffException() {
		super(ERR_ATTENDANCE_TODAY_IS_DAYOFF.getMessage(), ERR_ATTENDANCE_TODAY_IS_DAYOFF.getStatus());
	}
}
