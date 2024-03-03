package com.example.warmingup_miniproject.exception.message;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ExceptionMessage {
	ERR_TEAM_ALREADY_EXISTS("같은 이름을 가진 팀이 존재합니다."),
	ERR_TEAM_DOES_NOT_EXISTS("존재하지 않는 팀입니다."),
	ERR_TEAM_ALREADY_HAS_MANAGER("해당 팀은 이미 매니저가 있습니다."),

	ERR_EMPLOYEE_DOES_NOT_EXIST("존재하지 않는 직원입니다."),

	ERR_ATTENDANCE_RECORD_EXISTS("이미 출근한 직원입니다."),
	ERR_GET_OFF_NOT_AVAILABLE("출근 기록이 없으면 퇴근을 기록할 수 없습니다.");

	private final String message;
}
