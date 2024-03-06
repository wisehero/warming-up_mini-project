package com.example.warmingup_miniproject.exception.team;

import static com.example.warmingup_miniproject.exception.message.ExceptionMessage.*;

import com.example.warmingup_miniproject.exception.WarmingUpException;

public class TeamAlreadyExistsException extends WarmingUpException {

	public TeamAlreadyExistsException() {
		super(ERR_TEAM_ALREADY_EXISTS.getMessage(), ERR_TEAM_ALREADY_EXISTS.getStatus());
	}
}
