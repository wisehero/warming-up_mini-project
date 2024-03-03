package com.example.warmingup_miniproject.exception.team;

import com.example.warmingup_miniproject.exception.WarmingUpException;
import com.example.warmingup_miniproject.exception.message.ExceptionMessage;

public class TeamAlreadyHasManagerException extends WarmingUpException {
	public TeamAlreadyHasManagerException() {
		super(ExceptionMessage.ERR_TEAM_ALREADY_HAS_MANAGER.name());
	}
}
