package com.example.warmingup_miniproject.api;

import java.time.YearMonth;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.warmingup_miniproject.dto.attendance.ResponseAttendanceInfoByEmployee;
import com.example.warmingup_miniproject.service.AttendanceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/attendances")
@RequiredArgsConstructor
public class AttendanceController {

	private final AttendanceService attendanceService;

	@PostMapping("/{employeeId}")
	public void recordGoToWorkTime(@PathVariable("employeeId") Long employeeId) {
		attendanceService.recordGoToWorkTime(employeeId);
	}

	@PutMapping("/{employeeId}")
	public void recordGetOffWorkTime(@PathVariable("employeeId") Long employeeId) {
		attendanceService.recordGetOffWorkTime(employeeId);
	}

	@GetMapping("/{employeeId}")
	public ResponseAttendanceInfoByEmployee getAttendanceInfoByEmployee(
			@PathVariable("employeeId") Long employeeId,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM") YearMonth date) {
		return attendanceService.getAttendanceInfoByEmployee(employeeId, date);
	}
}
