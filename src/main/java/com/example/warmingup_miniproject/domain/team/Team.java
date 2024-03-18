package com.example.warmingup_miniproject.domain.team;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 30, unique = true)
	private String teamName;

	private int dayOffApplyDeadline;

	public Team(String teamName) {
		this.teamName = teamName;
		this.dayOffApplyDeadline = 7;
	}

	public void changeDayOffApplyDeadline(int day) {
		this.dayOffApplyDeadline = day;
	}
}
