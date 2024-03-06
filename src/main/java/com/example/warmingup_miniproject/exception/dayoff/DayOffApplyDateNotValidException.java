package com.example.warmingup_miniproject.exception.dayoff;

import static com.example.warmingup_miniproject.exception.message.ExceptionMessage.*;

import com.example.warmingup_miniproject.exception.WarmingUpException;

public class DayOffApplyDateNotValidException extends WarmingUpException {
	public DayOffApplyDateNotValidException() {
		super(ERR_DAYOFF_APPLY_DATE_NOT_VALID.getMessage(),
				ERR_DAYOFF_APPLY_DATE_NOT_VALID.getStatus());
	}
}
