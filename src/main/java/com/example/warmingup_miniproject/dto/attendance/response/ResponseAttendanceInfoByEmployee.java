package com.example.warmingup_miniproject.dto.attendance.response;

import java.util.List;

public record ResponseAttendanceInfoByEmployee(
		List<AttendanceDetail> detail,
		Long sum
) {
}
