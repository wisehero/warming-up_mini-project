package com.example.warmingup_miniproject.exception.message;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ExceptionMessage {
	ERR_TEAM_ALREADY_EXISTS("같은 이름을 가진 팀이 존재합니다."),
	ERR_TEAM_DOES_NOT_EXISTS("존재하지 않는 팀입니다."),
	ERR_TEAM_ALREADY_HAS_MANAGER("해당 팀은 이미 매니저가 있습니다.");

	private final String message;
}
