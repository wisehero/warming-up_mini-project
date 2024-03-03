package com.example.warmingup_miniproject.dto.team;

public record ResponseTeamInfo(
		String teamName,
		String manager,
		int totalMember
) {
}
