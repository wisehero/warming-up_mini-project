package com.example.warmingup_miniproject.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.warmingup_miniproject.domain.dayoff.DayOff;
import com.example.warmingup_miniproject.domain.dayoff.DayOffRepository;
import com.example.warmingup_miniproject.domain.employee.Employee;
import com.example.warmingup_miniproject.domain.employee.EmployeeRepository;
import com.example.warmingup_miniproject.domain.team.Team;
import com.example.warmingup_miniproject.dto.dayoff.request.RequestDayOffCreate;
import com.example.warmingup_miniproject.dto.dayoff.response.ResponseDayOffCreate;
import com.example.warmingup_miniproject.exception.dayoff.DayOffAlreadyAppliedException;
import com.example.warmingup_miniproject.exception.dayoff.DayOffApplyDateNotValidException;
import com.example.warmingup_miniproject.exception.dayoff.DayOffNoRemainException;
import com.example.warmingup_miniproject.exception.employee.EmployeeDoesNotExistException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DayOffService {

	private final DayOffRepository dayOffRepository;
	private final EmployeeRepository employeeRepository;

	@Transactional
	public ResponseDayOffCreate applyDayOff(RequestDayOffCreate request) {
		Employee employee = employeeRepository.findById(request.employeeId())
				.orElseThrow(EmployeeDoesNotExistException::new);
		Team team = employee.getTeam();
		LocalDate applyDate = request.applyDate();

		// 남은 연차가 없으면 예외 발생
		if (employee.getDayOffRemain() == 0) {
			throw new DayOffNoRemainException();
		}

		// (연차 사용일 - 연차 신청일)이 팀에서 지정한 날짜보다 작으면 예외
		long daysBetween = ChronoUnit.DAYS.between(LocalDate.now(), applyDate);
		if (daysBetween < team.getDayOffApplyDeadline()) {
			throw new DayOffApplyDateNotValidException();
		}

		// 이미 해당 일자에 연차 사용을 신청했으면 ERR
		boolean alreadyApplied = dayOffRepository.isAlreadyAppliedDayOff(request.employeeId(), applyDate);
		if (alreadyApplied) {
			throw new DayOffAlreadyAppliedException();
		}

		DayOff dayOff = new DayOff(employee, applyDate);
		DayOff savedDayOff = dayOffRepository.save(dayOff);
		employee.subtractDayOffRemain();

		return new ResponseDayOffCreate(savedDayOff.getEmployee().getId(), savedDayOff.getDayOffDate());
	}
}
