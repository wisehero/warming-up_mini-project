package com.example.warmingup_miniproject.dto.dayoff.response;

import java.time.LocalDate;

public record ResponseDayOffCreate(
		Long employeeId,
		LocalDate dayOffDate
) {
}
