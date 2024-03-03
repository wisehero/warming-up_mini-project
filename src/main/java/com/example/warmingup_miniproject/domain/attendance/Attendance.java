package com.example.warmingup_miniproject.domain.attendance;

import java.time.Duration;
import java.time.LocalDateTime;

import com.example.warmingup_miniproject.domain.employee.Employee;

import jakarta.persistence.Column;
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
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;

	@Column(nullable = false, updatable = false)
	private LocalDateTime goToWorkTime;

	private LocalDateTime getOffWorkTime;

	private Long workingMinutes;

	public Attendance(Employee employee) {
		this.employee = employee;
		this.goToWorkTime = LocalDateTime.now();
		this.getOffWorkTime = null;
		this.workingMinutes = 0L;
	}

	public void recordGetOffWorkTime(LocalDateTime getOffWorkTime) {
		this.getOffWorkTime = getOffWorkTime;
	}

	public void recordWorkingMinutes() {
		this.workingMinutes = Duration.between(this.goToWorkTime, this.getOffWorkTime).toMinutes();
	}
}
