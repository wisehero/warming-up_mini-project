package com.example.warmingup_miniproject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.warmingup_miniproject.domain.employee.Employee;
import com.example.warmingup_miniproject.domain.employee.EmployeeRepository;
import com.example.warmingup_miniproject.domain.team.Team;
import com.example.warmingup_miniproject.domain.team.TeamRepository;
import com.example.warmingup_miniproject.dto.employee.request.RequestEmployeeCreate;
import com.example.warmingup_miniproject.dto.employee.response.ResponseEmployeeCreate;
import com.example.warmingup_miniproject.dto.employee.response.ResponseEmployeeDayOffRemains;
import com.example.warmingup_miniproject.dto.employee.response.ResponseEmployeeInfo;
import com.example.warmingup_miniproject.exception.employee.EmployeeDoesNotExistException;
import com.example.warmingup_miniproject.exception.team.TeamAlreadyHasManagerException;
import com.example.warmingup_miniproject.exception.team.TeamDoesNotExistException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final TeamRepository teamRepository;

	@Transactional
	public ResponseEmployeeCreate createEmployee(RequestEmployeeCreate request) {
		Team team = teamRepository.findByTeamName(request.teamName()).orElseThrow(TeamDoesNotExistException::new);

		if (employeeRepository.existsByTeamIdAndRole(team.getId(), request.role())) {
			throw new TeamAlreadyHasManagerException();
		}

		Employee employee = request.toEntity();
		employee.assignTeam(team);
		Employee savedEmployee = employeeRepository.save(employee);

		return new ResponseEmployeeCreate(savedEmployee.getName(), savedEmployee.getTeam().getTeamName(),
				savedEmployee.getRole(), savedEmployee.getWorkStartDate(), savedEmployee.getBirthDay());
	}

	public List<ResponseEmployeeInfo> findAllEmployee() {
		return employeeRepository.findAll().stream()
				.map(employee -> new ResponseEmployeeInfo(
						employee.getName(),
						employee.getTeam().getTeamName(),
						employee.getRole(),
						employee.getBirthDay(),
						employee.getWorkStartDate()
				)).collect(Collectors.toList());
	}

	public ResponseEmployeeDayOffRemains getDayOffRemains(Long employeeId) {
		Employee findEmployee = employeeRepository.findById(employeeId).orElseThrow(EmployeeDoesNotExistException::new);
		return new ResponseEmployeeDayOffRemains(findEmployee.getName(), findEmployee.getDayOffRemain());
	}
}
