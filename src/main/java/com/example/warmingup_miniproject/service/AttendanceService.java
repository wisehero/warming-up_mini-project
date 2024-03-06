package com.example.warmingup_miniproject.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.warmingup_miniproject.domain.attendance.Attendance;
import com.example.warmingup_miniproject.domain.attendance.AttendanceRepository;
import com.example.warmingup_miniproject.domain.dayoff.DayOff;
import com.example.warmingup_miniproject.domain.dayoff.DayOffRepository;
import com.example.warmingup_miniproject.domain.employee.Employee;
import com.example.warmingup_miniproject.domain.employee.EmployeeRepository;
import com.example.warmingup_miniproject.dto.attendance.response.AttendanceDetail;
import com.example.warmingup_miniproject.dto.attendance.response.ResponseAttendanceInfoByEmployee;
import com.example.warmingup_miniproject.exception.attendance.AttendanceAlreadyArrivedException;
import com.example.warmingup_miniproject.exception.attendance.AttendanceGetOffNotAvailableException;
import com.example.warmingup_miniproject.exception.attendance.AttendanceTodayIsDayOffException;
import com.example.warmingup_miniproject.exception.employee.EmployeeDoesNotExistException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AttendanceService {

	private final AttendanceRepository attendanceRepository;
	private final EmployeeRepository employeeRepository;
	private final DayOffRepository dayOffRepository;

	@Transactional
	public void recordGoToWorkTime(Long employeeId) {
		// 등록되지 않은 직원이 출근할 수 없다.
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(EmployeeDoesNotExistException::new);

		LocalDate today = LocalDate.now();
		Optional<Attendance> attendedEmployee = attendanceRepository.findAttendedEmployee(employee.getId(), today);

		// 연차를 이미 사용한 날짜엔 출근을 기록할 수 없다.
		if (dayOffRepository.existsByEmployeeIdAndDayOffDate(employee.getId(), today)) {
			throw new AttendanceTodayIsDayOffException();
		}

		if (attendedEmployee.isPresent()) {
			Attendance attendance = attendedEmployee.get();
			// 당일 출근과 퇴근이 모두 기록되었다면 퇴근 시간을 null로 업데이트
			if (attendance.getGetOffWorkTime() != null) {
				attendance.recordGetOffWorkTime(null);
				return;
			}
			// 이미 당일날 출근을 등록한 경우 예외 발생
			throw new AttendanceAlreadyArrivedException();
		}
		attendanceRepository.save(new Attendance(employee));
	}

	@Transactional
	public void recordGetOffWorkTime(Long employeeId) {
		// 퇴근하려는 직원이 당일 출근하지 않았을 경우엔 ERR
		Attendance attendance = attendanceRepository.findAttendedEmployee(
				employeeId, LocalDate.now()).orElseThrow(AttendanceGetOffNotAvailableException::new);

		attendance.recordGetOffWorkTime(LocalDateTime.now());
		attendance.recordWorkingMinutes();
	}

	public ResponseAttendanceInfoByEmployee getAttendanceInfoByEmployee(Long employeeId, YearMonth date) {
		Employee findEmployee = employeeRepository.findById(employeeId).orElseThrow(EmployeeDoesNotExistException::new);
		LocalDate startOfMonth = date.atDay(1);
		LocalDate endOfMonth = date.atEndOfMonth();

		List<Attendance> attendanceInfo = attendanceRepository.findAttendanceByEmployeeId(findEmployee.getId(),
				startOfMonth,
				endOfMonth);

		List<DayOff> dayOffTaken = dayOffRepository.findDayOffTakenByEmployeeAndMonth(
				findEmployee.getId(), startOfMonth, endOfMonth);

		List<AttendanceDetail> details = attendanceInfo.stream()
				.map(attendance -> new AttendanceDetail(attendance.getGetOffWorkTime().toLocalDate(),
						attendance.getWorkingMinutes(), false))
				.collect(Collectors.toList());

		// 연차 정보도 AttendanceDetail 형태로 변환하여 details 리스트에 추가
		List<AttendanceDetail> dayOffDetails = dayOffTaken.stream()
				.map(dayOff -> new AttendanceDetail(dayOff.getDayOffDate(), 0L, true))
				.toList();
		details.addAll(dayOffDetails);
		details.sort(Comparator.comparing(AttendanceDetail::date));

		Long sum = details.stream().mapToLong(AttendanceDetail::workingMinutes)
				.sum();

		return new ResponseAttendanceInfoByEmployee(details, sum);
	}
}
