package com.example.warmingup_miniproject.dto.employee;

import static com.example.warmingup_miniproject.domain.employee.Role.*;

import java.time.LocalDate;

import com.example.warmingup_miniproject.domain.employee.Employee;
import com.example.warmingup_miniproject.domain.employee.Role;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public record RequestEmployeeCreate(
		@NotBlank(message = "직원의 이름은 비어있을 수 없습니다.")
		String name,
		Role role,
		@NotBlank(message = "팀 이름은 필수로 지정되어야 합니다.")
		String teamName,
		@FutureOrPresent(message = "현재 날짜보다 이전의 날짜가 입력될 수는 없습니다.")
		@JsonFormat(pattern = "yyyy-MM-dd")
		LocalDate workingStartDate,
		@PastOrPresent(message = "현재 이후의 날짜가 들어올 순 없습니다.")
		@JsonFormat(pattern = "yyyy-MM-dd")
		LocalDate birthDay
) {
	public RequestEmployeeCreate {
		if (role != MANAGER && role != MEMBER) {
			throw new IllegalArgumentException("Role은 Member 또는 Manager이어야 합니다.");
		}
	}

	public Employee toEntity() {
		return Employee.builder()
				.name(name)
				.role(role)
				.workStartDate(workingStartDate)
				.birthDay(birthDay)
				.build();
	}
}
