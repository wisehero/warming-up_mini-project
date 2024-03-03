package com.example.warmingup_miniproject.dto.attendance.response;

import java.time.LocalDate;

public record AttendanceDetail(
		LocalDate date,
		Long workingMinutes
) {
}
