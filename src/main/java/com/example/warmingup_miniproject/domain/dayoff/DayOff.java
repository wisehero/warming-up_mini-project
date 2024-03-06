package com.example.warmingup_miniproject.domain.dayoff;

import java.time.LocalDate;

import com.example.warmingup_miniproject.domain.employee.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class DayOff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;

	private LocalDate dayOffDate;

	public DayOff(Employee employee, LocalDate dayOffDate) {
		this.employee = employee;
		this.dayOffDate = dayOffDate;
	}
}
