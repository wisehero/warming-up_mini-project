package com.example.warmingup_miniproject.domain.employee;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

	public Employee(String name, Role role, LocalDate workStartDate, LocalDate birthDay) {
		this.name = name;
		this.role = role;
		this.workStartDate = workStartDate;
		this.birthDay = birthDay;
	}
}
