package com.example.warmingup_miniproject.exception.dayoff;

import static com.example.warmingup_miniproject.exception.message.ExceptionMessage.*;

import com.example.warmingup_miniproject.exception.WarmingUpException;

public class DayOffNoRemainException extends WarmingUpException {
	public DayOffNoRemainException() {
		super(ERR_DAYOFF_NO_REMAIN_DAYOFF.getMessage(), ERR_DAYOFF_NO_REMAIN_DAYOFF.getStatus());
	}
}
