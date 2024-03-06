package com.example.warmingup_miniproject.dto.dayoff.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record RequestDayOffCreate(
		@NotNull(message = "연차를 사용하려는 직원의 ID는 필수입니다.")
		Long employeeId,
		@Future(message = "연차를 신청하려는 날짜는 현재 혹은 현재 이전일 수 없습니다.")
		@NotNull
		LocalDate applyDate
) {
}
