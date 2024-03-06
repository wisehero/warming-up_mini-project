package com.example.warmingup_miniproject.exception.message;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionMessage {
	ERR_TEAM_ALREADY_EXISTS("같은 이름을 가진 팀이 존재합니다.", HttpStatus.BAD_REQUEST),
	ERR_TEAM_DOES_NOT_EXISTS("존재하지 않는 팀입니다.", HttpStatus.NOT_FOUND),
	ERR_TEAM_ALREADY_HAS_MANAGER("해당 팀은 이미 매니저가 있습니다.", HttpStatus.BAD_REQUEST),

	ERR_EMPLOYEE_DOES_NOT_EXIST("존재하지 않는 직원입니다.", HttpStatus.NOT_FOUND),

	ERR_ATTENDANCE_RECORD_EXISTS("이미 출근한 직원입니다.", HttpStatus.BAD_REQUEST),
	ERR_GET_OFF_NOT_AVAILABLE("출근 기록이 없으면 퇴근을 기록할 수 없습니다.", HttpStatus.BAD_REQUEST),

	ERR_DAYOFF_APPLY_DATE_NOT_VALID("연차 신청이 유효하지 않은 날짜입니다. 매니저에게 문의하세요.", HttpStatus.BAD_REQUEST),
	ERR_DAYOFF_ALREADY_APPLIED_DATE("이미 해당 일자에 연차 사용을 신청하셨습니다.", HttpStatus.BAD_REQUEST),
	ERR_DAYOFF_NO_REMAIN_DAYOFF("잔여 연차가 없습니다.", HttpStatus.BAD_REQUEST);

	private final String message;
	private final HttpStatus status;
}
