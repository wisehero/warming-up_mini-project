package com.example.warmingup_miniproject.dto.employee;

import java.time.LocalDate;

import com.example.warmingup_miniproject.domain.employee.Role;

public record ResponseEmployeeCreate(
		String name,
		String teamName,
		Role role,
		LocalDate workStartDate,
		LocalDate birthDate
) {
}
