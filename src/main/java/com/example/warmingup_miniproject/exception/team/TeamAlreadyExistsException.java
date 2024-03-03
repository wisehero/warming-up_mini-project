package com.example.warmingup_miniproject.exception.team;

import com.example.warmingup_miniproject.exception.WarmingUpException;
import com.example.warmingup_miniproject.exception.message.ExceptionMessage;

public class TeamAlreadyExistsException extends WarmingUpException {

	public TeamAlreadyExistsException() {
		super(ExceptionMessage.ERR_TEAM_ALREADY_EXISTS.name());
	}
}
