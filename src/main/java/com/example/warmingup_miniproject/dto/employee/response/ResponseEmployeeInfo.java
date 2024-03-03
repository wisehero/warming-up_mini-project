package com.example.warmingup_miniproject.dto.employee.response;

import java.time.LocalDate;

import com.example.warmingup_miniproject.domain.employee.Role;

public record ResponseEmployeeInfo(
		String name,
		String teamName,
		Role role,
		LocalDate birthDate,
		LocalDate workingStartDate
) {
}
