package com.example.warmingup_miniproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.warmingup_miniproject.domain.team.Team;
import com.example.warmingup_miniproject.domain.team.TeamRepository;
import com.example.warmingup_miniproject.domain.employee.Employee;
import com.example.warmingup_miniproject.domain.employee.EmployeeRepository;
import com.example.warmingup_miniproject.dto.team.ResponseTeamCreate;
import com.example.warmingup_miniproject.dto.team.ResponseTeamInfo;
import com.example.warmingup_miniproject.exception.TeamAlreadyExistsException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TeamService {

	private final TeamRepository teamRepository;
	private final EmployeeRepository employeeRepository;

	@Transactional
	public ResponseTeamCreate createTeam(Team team) {
		if (teamRepository.existsTeamByTeamName(team.getTeamName())) {
			throw new TeamAlreadyExistsException();
		}

		Team savedTeam = teamRepository.save(team);
		return new ResponseTeamCreate(savedTeam.getId(), savedTeam.getTeamName());
	}

	public List<ResponseTeamInfo> findAllTeamInfo() {
		List<Team> allTeam = teamRepository.findAll(); // 팀은 팀 id, 팀 이름을 가지고 있음.
		List<ResponseTeamInfo> teamInfos = new ArrayList<>();
		for (Team team : allTeam) {
			Long teamId = team.getId();

			int countEmployees = employeeRepository.countEmployeesByTeamId(teamId);
			String managerName = employeeRepository.findManagerByTeamId(teamId)
					.map(Employee::getName)
					.orElse(null);
			teamInfos.add(new ResponseTeamInfo(team.getTeamName(), managerName, countEmployees));
		}
		return teamInfos;
	}
}
