package com.example.warmingup_miniproject.exception.dayoff;

import static com.example.warmingup_miniproject.exception.message.ExceptionMessage.*;

import com.example.warmingup_miniproject.exception.WarmingUpException;

public class DayOffAlreadyAppliedException extends WarmingUpException {
	public DayOffAlreadyAppliedException() {
		super(ERR_DAYOFF_ALREADY_APPLIED_DATE.getMessage(),
				ERR_DAYOFF_ALREADY_APPLIED_DATE.getStatus());
	}
}
