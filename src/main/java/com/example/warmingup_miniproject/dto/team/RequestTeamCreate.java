package com.example.warmingup_miniproject.dto.team;

import com.example.warmingup_miniproject.domain.department.Team;

import jakarta.validation.constraints.NotBlank;

public record RequestTeamCreate(
		@NotBlank(message = "팀 이름은 비어있을 수 없습니다.")
		String teamName
) {
	public Team toEntity() {
		return new Team(this.teamName);
	}
}
