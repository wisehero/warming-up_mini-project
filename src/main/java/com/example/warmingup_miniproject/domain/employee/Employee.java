package com.example.warmingup_miniproject.domain.employee;

import java.time.LocalDate;

import com.example.warmingup_miniproject.domain.department.Team;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(nullable = false, updatable = false)
	private LocalDate workStartDate;

	@Column(nullable = false, updatable = false)
	private LocalDate birthDay;

	@ManyToOne(fetch = FetchType.LAZY)
	private Team team;

	@Builder
	public Employee(String name, Role role, LocalDate workStartDate, LocalDate birthDay, Team team) {
		this.name = name;
		this.role = role;
		this.workStartDate = workStartDate;
		this.birthDay = birthDay;
		this.team = team;
	}

	public void assignTeam(Team team) {
		this.team = team;
	}
}
