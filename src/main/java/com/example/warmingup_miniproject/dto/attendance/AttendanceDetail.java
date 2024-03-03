package com.example.warmingup_miniproject.dto.attendance;

import java.time.LocalDate;

public record AttendanceDetail(
		LocalDate date,
		Long workingMinutes
) {
}
