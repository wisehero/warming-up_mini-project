package com.example.warmingup_miniproject.exception.team;

import static com.example.warmingup_miniproject.exception.message.ExceptionMessage.*;

import com.example.warmingup_miniproject.exception.WarmingUpException;

public class TeamDoesNotExistException extends WarmingUpException {

	public TeamDoesNotExistException() {
		super(ERR_TEAM_DOES_NOT_EXISTS.name());
	}
}
