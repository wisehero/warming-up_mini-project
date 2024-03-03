package com.example.warmingup_miniproject.exception;

import static com.example.warmingup_miniproject.exception.message.ExceptionMessage.*;

public class TeamDoesNotExistException extends WarmingUpException {

	public TeamDoesNotExistException() {
		super(ERR_TEAM_DOES_NOT_EXISTS.name());
	}
}
