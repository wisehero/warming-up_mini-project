package com.example.warmingup_miniproject.dto.attendance;

import java.util.List;

public record ResponseAttendanceInfoByEmployee(
		List<AttendanceDetail> detail,
		Long sum
) {
}
