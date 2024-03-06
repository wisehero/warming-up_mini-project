package com.example.warmingup_miniproject.exception.team;

import static com.example.warmingup_miniproject.exception.message.ExceptionMessage.*;

import com.example.warmingup_miniproject.exception.WarmingUpException;

public class TeamAlreadyHasManagerException extends WarmingUpException {

	public TeamAlreadyHasManagerException() {
		super(ERR_TEAM_ALREADY_HAS_MANAGER.getMessage(),
				ERR_TEAM_ALREADY_HAS_MANAGER.getStatus());
	}

}
